package com.nature.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		//基于xml的bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person person = context.getBean("person",Person.class);
		System.out.println("person = " + person);
	}
}
