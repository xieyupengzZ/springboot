package com.xieyupeng.springboot.studys.DesignMode.ProxyMode;

/**
 * Created by XYP on 2018/4/14.
 * 静态代理
 * 多种功能或多个委托人，需要使用多个代理。因为一个代理里面有对委托人的引用，一一对应，耦合度高，增加委托人，必须重新使用一个新的代理。
 * 弊端很明显，就是代理类会越来越多，代码会越来越臃肿。于是有就有动态代理。
 */
public class TargetOne implements AbstractTarget {

    EntrustPerson entrustPerson;

    TargetOne(EntrustPerson entrustPerson){
        this.entrustPerson = entrustPerson;
    }

    @Override
    public void execute() {
        entrustPerson.execute();
    }
}
