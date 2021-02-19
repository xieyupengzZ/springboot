package com.xieyupeng.springboot.studys.Multithreading;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 查看 lock 、 condition 使用时，线程的状态
 */
public class LockConditionTest {

    Lock lock;
    Condition A;
    Condition B;

    LockConditionTest(Lock lock,Condition A,Condition B){
        this.lock = lock;
        this.A = A;
        this.B = B;
    }

    void test1() throws InterruptedException {

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "拿到了锁");
            Thread.sleep(5000);
            A.await();
            System.out.println(Thread.currentThread().getName() + "又一次拿到了锁");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        } finally {
            lock.unlock();
        }
    }


    void test2() throws InterruptedException {
        lock.lock();
        A.signalAll();
        System.out.println(Thread.currentThread().getName() + "唤醒了所有");
        Thread.sleep(5000);
        lock.unlock();
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "唤醒后的睡眠结束");
    }


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        LockConditionTest test = new LockConditionTest(lock,A,B);
        for(int i = 0 ; i < 3 ; i ++){
            new Thread(()->
            {
                try {
                    System.out.println(Thread.currentThread().getName() + "执行");
                    test.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(3000);
        test.test2();
    }

}
