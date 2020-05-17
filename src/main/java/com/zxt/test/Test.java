package com.zxt.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Filter f1 = new Filter();
		// 查询用户id为10的用户
		f1.setId(10);

		Filter f2 = new Filter();
		// 查询用户名为lucy 且 年龄为12 的用户
		f2.setUserName("lucy");
		f2.setAge(12);

		Filter f3 = new Filter();
		// 查询邮箱为其中之一的用户
		f3.setEmail("123@qq.com,abc@163.com,7777@sina.com");

		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
	}

	/**
	 * 
	 * @Description：query方法的实现，通过反射机制来读取注解
	 * 
	 * @param f
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static String query(Filter f) {
		StringBuilder sb = new StringBuilder();

		// 解析注解
		// 1.获取class
		@SuppressWarnings("rawtypes")
		Class clazz = f.getClass();
		// 2.获取到table的名称
		boolean tableExist = clazz.isAnnotationPresent(Table.class);
		if (!tableExist) {
			return null;
		}

		Table t = (Table) clazz.getAnnotation(Table.class);
		String tableName = t.value();
		sb.append("select * from ").append(tableName).append(" where 1 = 1 ");

		// 3.遍历所有的字段，如果有值就加到查询条件中
		Field[] fieldArray = clazz.getDeclaredFields();
		for (Field field : fieldArray) {
			// 4.处理每个字段相对应的sql
			boolean fieldExist = field.isAnnotationPresent(Column.class);
			if (!fieldExist) {
				continue;
			}

			// 4.1.获取字段名
			String fieldName = field.getName();
			
			// 4.2.拿到字段的值（通过字段名相应的get方法）
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + 
					fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = clazz.getMethod(getMethodName);
				// 反射调用
				fieldValue = getMethod.invoke(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 4.3.拼接sql
			if(fieldValue == null || 
					(fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
				continue;
			}
			sb.append("and ").append(fieldName);
			if(fieldValue instanceof String) {
				if(((String) fieldValue).contains(",")) {
					String[] fieldValues = ((String) fieldValue).split(",");
					sb.append(" in (");
					for(String value : fieldValues) {
						sb.append("'").append(value).append("',");
					}
					sb.deleteCharAt(sb.length() - 1);
					sb.append(")");
				} else {
					sb.append(" = '").append(fieldValue).append("'");
				}
				
			} else if(fieldValue instanceof Integer) {
				sb.append(" = ").append(fieldValue);
			}
		}

		return sb.toString();
	}
}
