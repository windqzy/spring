package com.nature.spring;

import com.nature.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 {
	public static void main(String[] args) {
		//基于xml的bean
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
	}
}


