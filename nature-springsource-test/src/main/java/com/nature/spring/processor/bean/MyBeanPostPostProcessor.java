package com.nature.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author qinzhiying
 * @date 2023/02/14 18:10
 **/
public class MyBeanPostPostProcessor implements BeanFactoryPostProcessor {
	public MyBeanPostPostProcessor() {
		System.out.println("MyBeanPostPostProcessor");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanPostPostProcessor...postProcessBeanFactory...Override");
	}
}
