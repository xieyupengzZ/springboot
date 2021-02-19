package com.xieyupeng.springboot.studys.DesignMode.SingletonMode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoubleLockSingleton {

    private static DoubleLockSingleton doubleLockSingleton = null;
    //构造函数私有化
    private DoubleLockSingleton() {}

    //双加锁
    //只能通过一个公共方法获取该类对象
    public static DoubleLockSingleton get() {
        if(doubleLockSingleton==null) {
            System.out.println(Thread.currentThread().getName()+"发现为空进来了");
            synchronized(DoubleLockSingleton.class){
            System.out.println(Thread.currentThread().getName()+"获取了锁");
                if (doubleLockSingleton == null) {
                    System.out.println(Thread.currentThread().getName()+"只有我进来了");
                    try {
                        Thread.sleep(100000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    doubleLockSingleton = new DoubleLockSingleton();
                    System.out.println(Thread.currentThread().getName()+"创建了对象不为空了");
               }
            }
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
        return doubleLockSingleton;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i ++){
            new Thread(()->
                    DoubleLockSingleton.get()
            ).start();
        }
    }
}
