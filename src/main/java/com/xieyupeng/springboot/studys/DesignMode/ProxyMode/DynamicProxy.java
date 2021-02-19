package com.xieyupeng.springboot.studys.DesignMode.ProxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XYP on 2018/4/14.
 * jdk代理，接口代理，目标对象必须实现接口
 */
public class DynamicProxy implements InvocationHandler{

    private AbstractTarget abstractTarget;

    DynamicProxy(AbstractTarget abstractTarget){
        this.abstractTarget = abstractTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("委托人的方法，从下面被调用，额外业务逻辑，可以写在前面");
        Object result = method.invoke(abstractTarget,args); //反射
        System.out.println("调用结束啦，还想干嘛，还是找代理");
        return result;
    }

    //创建动态代理对象
    public AbstractTarget getProxy(){
        return (AbstractTarget) Proxy.newProxyInstance(
                abstractTarget.getClass().getClassLoader(),
                abstractTarget.getClass().getInterfaces(),
                this
        );
    }
    public static void main(String[] args) {
        AbstractTarget persion = new EntrustPerson();
        DynamicProxy proxy = new DynamicProxy(persion);
        proxy.getProxy().execute();
    }
}
