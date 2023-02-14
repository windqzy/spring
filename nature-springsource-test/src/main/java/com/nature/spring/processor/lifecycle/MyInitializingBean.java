package com.nature.spring.processor.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * 生命周期接口
 *
 * @author qinzhiying
 * @date 2023/02/14 18:25
 **/
public class MyInitializingBean implements InitializingBean {
	public MyInitializingBean() {
		System.out.println("MyInitializingBean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyInitializingBean...afterPropertiesSet...Override");
	}
}
