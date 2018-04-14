package com.xieyupeng.springboot.DesignMode.ProxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XYP on 2018/4/14.
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler{

    //真实对象
    Object entrustObject;
    DynamicProxy(Object entrustObject){
        this.entrustObject = entrustObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args); //反射
    }

    public static void main(String[] args) {
        AbstractProxy persion = new EntrustPerson();
        DynamicProxy proxy = new DynamicProxy(persion);
        //创建动态代理对象
        AbstractProxy abstractProxy = (AbstractProxy) Proxy.newProxyInstance(
                persion.getClass().getClassLoader(),
                new Class[]{AbstractProxy.class},
                proxy);
        persion.execute();
    }
}
