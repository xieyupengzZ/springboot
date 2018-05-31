package com.xieyupeng.springboot.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程中断测试，什么情况下能中断
 * Thread.sleep、Object.wait()、condition.await() 等方法能响应中断
 *
 * 1、如果在某线程 由于 Synchronize 关键字阻塞的状态下调用它的中断，不会终止阻塞。
 * 但是当它拿到锁，调用 sleep或 wait方法时，中断就直接生效了。好像之前的中断是一个标记，后面触发了。execute1()方法。
 *
 * 2、如果在某线程 由于 lock.lockInterruptibly 锁阻塞的状态下，调用该线程的中断方法，会直接终止阻塞。
 * 但是如果它拿到这个锁，在里面调用 condition.await() 方法等待，陆续多个线程都这样进入等待，然后一起被唤醒，只有一个线程能拿到锁继续执行，
 *
 * 对某个阻塞的线程如果再调用中断方法，就会不立即终止阻塞了。同样的，像第一点一样，如果等到它拿到锁，调用 sleep或 await 方法时，中断就直接生效了。execute2()方法。
 * 3、如果在某线程 由于 lock.lock 阻塞的状态下，调用它的中断方法，不会响应中断，而是等到它拿到锁之后，再根据情况处理，比如，调用 sleep 和 await 方法就会响应中断。
 */
public class InterruptedTest {
    List<Thread> threads;
    Lock lock = new ReentrantLock();
    Condition c = lock.newCondition();

    InterruptedTest(List<Thread> threads){
        this.threads = threads;
    }

    synchronized void objectWait(){
        System.out.println(Thread.currentThread().getName() + "获得锁");
        try {
            System.out.println(Thread.currentThread().getName() + "进入睡眠");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "进入等待");
            this.wait();
            System.out.println(Thread.currentThread().getName() + "又获得了锁");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
            System.out.println();
        }
    }

    synchronized void objectNotifyAll(){
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + "唤醒了所有剩下的线程");
    }

    void execute1() throws InterruptedException {
        for(int i = 0 ; i < 6; i ++){
            new Thread(()-> {
                threads.add(Thread.currentThread());
                objectWait();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("尝试中断阻塞状态的 "+threads.get(1).getName() + " "+threads.get(1).getState());
        threads.get(1).interrupt();
        System.out.println("尝试中断睡眠状态的"+threads.get(0).getName());
        threads.get(0).interrupt();
        Thread.sleep(40000);
        System.out.println();
        System.out.println("所有线程都处于等待状态了");
        System.out.println("尝试中断等待状态的 "+threads.get(2).getName() + " "+threads.get(2).getState());
        threads.get(2).interrupt();

        Thread.sleep(1000);
        objectNotifyAll();

        Thread.sleep(2000);
        System.out.println(threads.size());
        System.out.println("尝试中断唤醒后阻塞的线程 "+threads.get(5).getName() + " "+threads.get(5).getState());
        threads.get(5).interrupt();
    }

    void conditionWait(){
        try {
//            lock.lock();
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "获得锁");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "进入等待");
            c.await();
            System.out.println(Thread.currentThread().getName() + "又获得了锁");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
        } finally {
            lock.unlock();
        }
    }

    void conditionNofity(){
        lock.lock();
        c.signalAll();
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "唤醒了所有剩下的线程");
    }

    void execute2() throws InterruptedException {
        for(int i = 0 ; i < 6; i ++){
            new Thread(()-> {
                threads.add(Thread.currentThread());
                conditionWait();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("尝试中断阻塞状态的 "+threads.get(1).getName() + " "+threads.get(1).getState());
        threads.get(1).interrupt();
        Thread.sleep(1000);
        System.out.println("尝试中断睡眠状态的"+threads.get(0).getName());
        threads.get(0).interrupt();
        Thread.sleep(40000);
        System.out.println();
        System.out.println("所有线程都处于等待状态了");
        System.out.println("尝试中断等待状态的 "+threads.get(2).getName() + " "+threads.get(2).getState());
        threads.get(2).interrupt();

        Thread.sleep(1000);
        conditionNofity();

        Thread.sleep(2000);
        System.out.println("尝试中断唤醒后阻塞的线程 "+threads.get(5).getName() + " "+threads.get(5).getState());
        threads.get(5).interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new Vector<Thread>(3);
        InterruptedTest test = new InterruptedTest(threads);
//        test.execute1();
        test.execute2();
    }
}
