package com.nature.spring.bean;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class Cat implements InitializingBean {
	private String name;

	public Cat() {
		System.out.println("cat...constructor... ");
	}

	public String getName() {
		return name;
	}

	@Value("${JAVA_HOME}")
	public void setName(String name) {
		System.out.println("cat...setName()...Value");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("CatInitializingBean...afterPropertiesSet...Override");
	}
}
