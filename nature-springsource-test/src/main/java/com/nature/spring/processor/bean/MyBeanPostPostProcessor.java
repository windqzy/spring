package com.nature.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author qinzhiying
 * @date 2023/02/14 18:10
 **/
@Component
public class MyBeanPostPostProcessor implements BeanFactoryPostProcessor {
	public MyBeanPostPostProcessor() {
		System.out.println("MyBeanPostPostProcessor...constructor");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanPostPostProcessor...postProcessBeanFactory...Override");
	}
}
