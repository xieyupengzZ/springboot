package com.xieyupeng.springboot.DesignMode.ObserverMode;

public class ObserverTwo extends AbstractObserver{

    @Override
    public void getResult(String name) {
        System.out.println(name+" 收到你的消息了");
    }
}
