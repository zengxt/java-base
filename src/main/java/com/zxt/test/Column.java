package com.zxt.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Column注解的作用域为属性
@Target(ElementType.FIELD)
// 在运行时解析
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	
	// 标注属性名
	String value();
}
