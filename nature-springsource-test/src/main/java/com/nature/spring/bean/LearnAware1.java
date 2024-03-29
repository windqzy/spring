package com.nature.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
//实现ApplicationContextAware接口 回调的方式实现
//@Component
public class LearnAware1 implements ApplicationContextAware {
	private String name;

	private ApplicationContext applicationContext;


	public LearnAware1() {
		System.out.println("name = " + name);
	}

	public LearnAware1(String name) {
		System.out.println("name = " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
