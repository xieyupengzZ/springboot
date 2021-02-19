package com.xieyupeng.springboot.studys.BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

    public static void main(String[] args) {


        System.out.println("---------------------------初始化容器---------------------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");

        System.out.println("----------------------------展示信息----------------------------");
        System.out.println(" detail 变成个了 "+context.getBean(BeanTest.class).getDetail());
        System.out.println("知道我什么时候被修改的吗");

        System.out.println("----------------------------销毁容器----------------------------");
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();

    }
}
