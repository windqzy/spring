package com.nature.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 * 简单bean：就是person，cat这些组件
 * 工厂bean：就是实现FactoryBean #getObject方法返回的对象
 * @author qinzhiying
 * @date 2023/02/14 10:21
 **/
public class HelloFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
