package com.xieyupeng.springboot.studys.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    MyBeanFactoryPostProcessor(){
        System.out.println("【MyBeanFactoryPostProcessor】构造方法");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("【MyBeanFactoryPostProcessor】重写 postProcessBeanFactory 方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("beanTest");
        beanDefinition.getPropertyValues().addPropertyValue("detail","换汤不换药");
    }
}
