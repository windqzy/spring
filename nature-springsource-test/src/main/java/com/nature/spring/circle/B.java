package com.nature.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qinzhiying
 * @date 2023/02/23 14:47
 **/
@Component
public class B {

	private A a;

	@Autowired
	public void setA(A a) {
		 a = a;
	}
}
