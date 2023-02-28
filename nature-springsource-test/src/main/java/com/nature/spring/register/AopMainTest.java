package com.nature.spring.register;

import com.nature.spring.aop.HelloService;
import com.nature.spring.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMainTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		HelloService bean = context.getBean(HelloService.class);
		bean.sayHello("nature");
	}
}
