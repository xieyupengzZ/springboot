package com.xieyupeng.springboot.studys.Multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SynchronizedTest2 {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedTest2.class);
    SynchronizedTest synchronizedTest = new SynchronizedTest(1);

    //锁住了本类的某个实例对象
    public synchronized void test1() {
        try {
            logger.info(Thread.currentThread().getName() + " test1 进入");
            Thread.sleep(2000);
            synchronizedTest.test2();
            logger.info(Thread.currentThread().getName() + " test1 休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
