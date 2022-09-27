package com.nature.spring.config;

import com.nature.spring.Cat;
import com.nature.spring.Person;
import com.nature.spring.register.MyImportBeanDefinitionRegistrar;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 我的配置类
 */
@Import(Person.class)
//@Import({Person.class, MyImportBeanDefinitionRegistrar.class})
//@Import(MyImportBeanDefinitionRegistrar.class)
@ComponentScan("com.nature.spring")
@Configuration
public class MyConfig {
//	@Bean
//	public Person person(){
//		Person person = new Person();
//		person.setName("nature");
//		return person;
//	}


	/**
	 * 1.使用xml的方式创建ioc容器
	 * 2.使用注解的方式创建ioc容器
	 *   @Configuration, ImportSelector, ImportBeanDefinitionRegistrar, or regular component classes to import.
	 *   注解方式1：@Configuration
	 *   注解方式2：@Bean
	 *   注解方式3：@Import(类字面常量数组)：利用无参构造器创建
	 *   注解方式4：@ImportSelector
	 *   注解方式5：@ImportBeanDefinitionRegistrar 实现ImportBeanDefinitionRegistrar接口后Import
	 *	 注解方式6：
	 *
	 */
}
