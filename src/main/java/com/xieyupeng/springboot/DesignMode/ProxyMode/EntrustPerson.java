package com.xieyupeng.springboot.DesignMode.ProxyMode;

/**
 * Created by XYP on 2018/4/14.
 */
public class EntrustPerson implements AbstractProxy {
    @Override
    public void execute() {
        System.out.println("有什么事找我的代理人");
    }
}
