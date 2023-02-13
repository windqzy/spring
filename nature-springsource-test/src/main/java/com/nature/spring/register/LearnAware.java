package com.nature.spring.register;

import com.nature.spring.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LearnAware {
	private String name;

	@Autowired
	private ApplicationContext learnApplicationContext;
	public LearnAware() {
		System.out.println("name = " + name);
	}

	public LearnAware(String name) {
		System.out.println("name = " + name);
	}

	public ApplicationContext getLearnApplicationContext() {
		return learnApplicationContext;
	}

	public void setLearnApplicationContext(ApplicationContext learnApplicationContext) {
		this.learnApplicationContext = learnApplicationContext;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
