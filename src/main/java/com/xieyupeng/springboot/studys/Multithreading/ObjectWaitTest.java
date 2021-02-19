package com.xieyupeng.springboot.studys.Multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 测试 synchronized 、wait 使用时，线程状态变更
 */
public class ObjectWaitTest {

    synchronized void objectWait() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + "进来先休息一下");
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "休息完了放弃锁");
        this.wait();
        System.out.println(Thread.currentThread().getName() + "获得锁");
        Thread.sleep(5000);
    }

    synchronized void objectNotify() throws InterruptedException {
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()
                +"唤醒所有线程进入锁池并选择一个获取锁");
     }

    public static void main(String[] args) throws InterruptedException {
        ObjectWaitTest test = new ObjectWaitTest();
        for (int i = 0 ; i < 3 ; i ++){
            new Thread(()->
            {
                try {
                    System.out.println(Thread.currentThread().getName()+"调用同步块");
                    test.objectWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(40000); //保证3个线程代码都执行了 wait方法
        test.objectNotify();
    }

}
