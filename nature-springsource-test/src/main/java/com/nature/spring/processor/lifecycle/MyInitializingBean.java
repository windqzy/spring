package com.nature.spring.processor.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 生命周期接口
 *
 * @author qinzhiying
 * @date 2023/02/14 18:25
 **/
@Component
public class MyInitializingBean implements InitializingBean {
	public MyInitializingBean() {
		System.out.println("MyInitializingBean...constructor");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyInitializingBean...afterPropertiesSet...Override");
	}
}
