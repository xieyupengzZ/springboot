package com.xieyupeng.springboot.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SynchronizedTest {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedTest.class);

    public Integer lockObject;

    public SynchronizedTest(Integer lockObject) {
        this.lockObject = lockObject;
    }

    //锁住了本类的某个实例对象
    public synchronized void test1() {
        try {
            logger.info(Thread.currentThread().getName() + " test1 进入");
            Thread.sleep(5000);
            logger.info(Thread.currentThread().getName() + " test1 休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //锁住了本类的某个实例对象
    public void test2() {
        synchronized (this) {
            try {
                logger.info(Thread.currentThread().getName() + " test2 进入");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test2 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //全局锁，类是全局唯一的
    public void test3() {
        synchronized (SynchronizedTest.class) {
            try {
                logger.info(Thread.currentThread().getName() + " test3 进入");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test3 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //全局锁，静态方法全局唯一的
    public synchronized static void test4() {
        try {
            logger.info(Thread.currentThread().getName() + " test4 进入");
            Thread.sleep(5000);
            logger.info(Thread.currentThread().getName() + " test4 休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //锁住了本类的某个实例对象
    public void test5() {
        synchronized (lockObject) {
            try {
                logger.info(Thread.currentThread().getName() + " test5 进入");
                Thread.sleep(5000);
                logger.info(Thread.currentThread().getName() + " test5 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest st = new SynchronizedTest(1);
        SynchronizedTest st2 = new SynchronizedTest(1);
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test 准备进入");
            st.test4();
        }).start();
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test 准备进入");
            st2.test4();
        }).start();

    }
}
