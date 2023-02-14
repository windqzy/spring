package com.nature.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 简单bean：就是person，cat这些组件
 * 工厂bean：就是实现FactoryBean #getObject方法返回的对象 #getObjectType指定对象的类型
 * mybatis和spring的整合就是这种方式SqlSessionFactoryBean
 *
 * @author qinzhiying
 * @date 2023/02/14 10:21
 **/
//@Component
public class HelloFactoryBean implements FactoryBean<Hello> {
	@Override
	public Hello getObject() throws Exception {
		return new Hello();
	}

	@Override
	public Class<?> getObjectType() {
		return Hello.class;
	}
}
