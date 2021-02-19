package com.xieyupeng.springboot.studys.DesignMode.ObserverMode;

import java.util.ArrayList;
import java.util.List;

public class TargetOne extends AbstractTarget {

    List<AbstractObserver> observers = new ArrayList<AbstractObserver>();

    @Override
    public void registerObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AbstractObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (AbstractObserver observer : observers) {
            observer.getResult(observer.getClass().getName());
        }
    }
}
