package com.nature.spring;

import com.nature.spring.config.MyConfig;
import com.nature.spring.register.LearnAware;
import com.nature.spring.register.LearnAware1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMainTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

		//自动注入的applicationContext是同一个么？
		LearnAware learnAware = context.getBean(LearnAware.class);
		ApplicationContext learnApplicationContext = learnAware.getLearnApplicationContext();
		System.out.println(learnApplicationContext == context);//true

		LearnAware1 learnAware1 = context.getBean(LearnAware1.class);
		ApplicationContext learnApplicationContext1 = learnAware1.getApplicationContext();
		System.out.println(learnApplicationContext1 == context);//true


	}
}
