package com.zxt.metaannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Table {
	/**
	 * 
	 * @Description：数据表名称注解，默认值为类名称
	 * 
	 * @return
	 */
	public String tableName() default "className";
}


