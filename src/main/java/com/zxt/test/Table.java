package com.zxt.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Table注解的作用域为类或者接口
@Target(ElementType.TYPE)
// 在运行时解析
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	
	// 只有一个值标明表名即可
	String value();
}
