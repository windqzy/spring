package com.nature.spring;

import com.nature.spring.bean.Cat;
import com.nature.spring.bean.Person;
import com.nature.spring.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMainTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Person person = context.getBean(Person.class);
//		System.out.println("person = " + person);
//		System.out.println("中文不乱码");


		//获取所有的beanName
//		String[] beanDefinitionNames = context.getBeanDefinitionNames();
//		for (String beanDefinitionName : beanDefinitionNames) {
//			System.out.println("beanDefinitionName = " + beanDefinitionName);
//		}
//		Cat cat1 = context.getBean(Cat.class);
//		Cat cat2 = context.getBean(Cat.class);
//		System.out.println(cat1==cat2);//false
//		if(cat1==cat2){
//			System.out.println("单实例！");
//		}
//		System.out.println("原型模式！");

		Person p1 = context.getBean(Person.class);
		Cat cat1 = p1.getCat();
		System.out.println("cat1 = " + cat1);
		Person p2 = context.getBean(Person.class);
		Cat cat2 = p2.getCat();
		System.out.println("cat2 = " + cat2);
		System.out.println(cat1==cat2);//true


	}
}
