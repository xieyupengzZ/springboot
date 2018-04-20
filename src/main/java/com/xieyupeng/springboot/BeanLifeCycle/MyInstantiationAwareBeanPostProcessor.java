package com.xieyupeng.springboot.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    MyInstantiationAwareBeanPostProcessor(){
        System.out.println("【InstantiationAwareBeanPostProcessor接口】实现类的构造函数");
    }


//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
//        System.out.println("【InstantiationAwareBeanPostProcessor接口】实例化bean之前调用 postProcessBeforeInstantiation方法");
//        return null;
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
//        System.out.println("【InstantiationAwareBeanPostProcessor接口】实例化bean之后调用 postProcessAfterInstantiation方法");
//        return false;
//    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[]
            propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor接口】设置某个属性时调用 postProcessPropertyValues方法");
        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor接口】实例化bean之前调用 postProcessBeforeInstantiation方法");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor接口】实例化bean之后调用 postProcessAfterInstantiation方法");
        return o;
    }
}
