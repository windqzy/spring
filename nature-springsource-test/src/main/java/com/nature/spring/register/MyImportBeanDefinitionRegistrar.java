package com.nature.spring.register;

import com.nature.spring.Cat;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
		@Override
		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
			//使用bean
			RootBeanDefinition catBeanDefinition = new RootBeanDefinition();
			catBeanDefinition.setBeanClass(Cat.class);
			registry.registerBeanDefinition("cat",catBeanDefinition);
		}
	}