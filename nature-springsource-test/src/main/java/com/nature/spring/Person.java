package com.nature.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;

	@Autowired
	private Cat cat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lookup//每次注入的时候都要去容器里获取一个新的cat
	public Cat getCat() {
		return cat;
	}


	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}
}
