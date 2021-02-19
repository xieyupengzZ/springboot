package com.xieyupeng.springboot.studys.DesignMode.ObserverMode;

public class ObserverOne extends AbstractObserver{

    @Override
    public void getResult(String name) {
        System.out.println(name+" 收到你的消息了");
    }
}
