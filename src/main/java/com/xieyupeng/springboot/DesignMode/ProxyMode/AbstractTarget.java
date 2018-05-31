package com.xieyupeng.springboot.DesignMode.ProxyMode;

/**
 * Created by XYP on 2018/4/14.
 * 代理模式
 * 涉及到三种角色：抽象角色，代理人，委托人。
 *
 * 1、代理 和 委托 都必须实现同一个接口，抽象类都不行。
 * 2、在 代理 中实例化 委托，再调用委托的方法
 */
public interface AbstractTarget {

    void execute();

}
