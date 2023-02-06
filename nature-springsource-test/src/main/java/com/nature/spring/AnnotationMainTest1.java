package com.nature.spring;

import com.nature.spring.config.MyConfig;
import com.nature.spring.register.LearnAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMainTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


		//自动注入的applicationContext是同一个么？
		LearnAware learnApplicationContext = context.getBean(LearnAware.class);
		ApplicationContext learnApplicationContext1 = learnApplicationContext.getLearnApplicationContext();
		System.out.println(learnApplicationContext1 == context);
	}
}
