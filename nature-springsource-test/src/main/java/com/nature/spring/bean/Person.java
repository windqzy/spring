package com.nature.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Person {
	private String name;
	//  依赖的组件是原型模式的组件就不能用autowired
	@Autowired
	private Cat cat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@Bean方式注入的person中使用@Lookup不起作用
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
