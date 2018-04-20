package com.xieyupeng.springboot.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;


public class BeanTest implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean {

    private String detail;

    private String beanName;
    private BeanFactory beanFactory;

    BeanTest(){
        System.out.println("【BeanTest构造方法】");
    }

    public void setDetail(String detail) {
        this.detail = detail;
        System.out.println("【set注入】detail 属性 "+detail);
    }
    public String getDetail(){
        return detail;
    }
    public void init(){
        System.out.println("【init-methodd】属性配置初始化方法");
    }

    public void destory(){
        System.out.println("【destory-method】属性配置销毁方法");
    }

    @Override
    public void setBeanName(String s) {
        beanName = s;
        System.out.println("【BeanNameAware接口】setBeanName 方法得到 Bean 的名称");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        beanFactory = beanFactory;
        System.out.println("【BeanFactoryAware接口】setBeanFactory 方法得到 BeanFatory 的引用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】destory 方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】afterPropertiesSet 方法");
    }
}
