package com.xieyupeng.springboot.studys.Multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//可重入锁机制测试（不同类中）
public class SynchronizedTest3 {

    private static final Logger logger = LoggerFactory.getLogger(SynchronizedTest3.class);

    public SynchronizedTest synchronizedTest = new SynchronizedTest(1);
    public SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();

    public static void main(String[] args) {
        SynchronizedTest st = new SynchronizedTest(1);
        SynchronizedTest2 st2 = new SynchronizedTest2();
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test- 准备进入");
            st.test2();
        }).start();
        new Thread(() -> {
            logger.info(Thread.currentThread().getName() + " test-- 准备进入");
            st2.test1();
        }).start();

    }
}
