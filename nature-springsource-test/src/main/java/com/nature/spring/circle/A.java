package com.nature.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinzhiying
 * @date 2023/02/23 14:46
 **/
@Component
public class A {

	private B b;

	@Autowired
	public void setB(B b) {
		b = b;
	}
}
