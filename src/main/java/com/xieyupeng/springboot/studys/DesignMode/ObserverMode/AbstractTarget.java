package com.xieyupeng.springboot.studys.DesignMode.ObserverMode;

/**
 * 抽象类和接口的区别（感性上）
 * 抽象类更像是描述一个东西，一个对象
 * 接口更像是一些操作的集合
 */
public abstract class AbstractTarget {

    //抽象类中可以有抽象方法，但是子类必须实现的。
    //也可以有方法体的方法，这样子类就不用强制实现它，甚至可以不理它(父类有默认实现)，只实现强制要求需要实现的方法。
    //如果需要额外的行为，子类可以自行实现，达到可选的弹性的效果（钩子方法就是这样的实现原理）。
    //按照逻辑上讲，这里应该都是抽象方法，因为子类必须实现。
    public void registerObserver(AbstractObserver observer) {

    }

    public void removeObserver(AbstractObserver observer) {

    }

    public void notifyObserver() {

    }
}
