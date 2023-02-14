package com.nature.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author qinzhiying
 * @date 2023/02/14 10:35
 **/
//@Component
public class Hello {
	private String name = "hello";

	public Hello() {
	}

	public Hello(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
