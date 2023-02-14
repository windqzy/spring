package com.nature.spring;

import com.nature.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {
	public static void main(String[] args) {
		//基于xml的bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		Person person = context.getBean("person",Person.class);
		System.out.println("person = " + person);
	}
}


