package com.xieyupeng.springboot.DesignMode.ObserverMode;

public class Execute {

    public static void main(String[] args) {
        AbstractTarget target = new TargetOne();
        AbstractObserver observer1 = new ObserverOne();
        AbstractObserver observer2 = new ObserverTwo();
        target.registerObserver(observer1);
        target.registerObserver(observer2);
        target.notifyObserver();
    }
}
