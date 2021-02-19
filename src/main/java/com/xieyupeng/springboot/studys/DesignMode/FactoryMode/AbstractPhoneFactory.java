package com.xieyupeng.springboot.studys.DesignMode.FactoryMode;

/**
 * 这里使用 工厂方法 模式
 *
 * 简单工厂，耦合度太高，每次增加新产品，就需要修改原来的工厂代码，违背了开闭原则，对扩展开放，对修改关闭
 * 工厂方法，解决了简单工厂的弊端
 * 抽象工厂，是解决复杂业务的，不同产品族，可以是同一产品结构，有点交叉的意思
 */

public interface AbstractPhoneFactory {

    public Phone createPhone();

}
