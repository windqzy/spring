package com.nature.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author qinzhiying
 * @date 2023/02/14 18:10
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	public MyBeanPostProcessor() {
		System.out.println("MyBeanPostPostProcessor...constructor");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessBeanFactory...Override");
		return bean;
	}
}
