package com.xieyupeng.springboot.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    MyBeanPostProcessor(){
        System.out.println("【MyBeanPostProcessor接口】构造方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("【MyBeanPostProcessor接口】postProcessBeforeInitialization 这里可对 "+s+ " 属性更改");
        return o;//记得这里要返回对象
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("【MyBeanPostProcessor接口】postProcessAfterInitialization 这里可对 "+s+" 属性更改");
        return o;//记得这里要返回对象
    }
}
