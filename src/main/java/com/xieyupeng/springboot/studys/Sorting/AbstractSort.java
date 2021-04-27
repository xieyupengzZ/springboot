package com.xieyupeng.springboot.studys.Sorting;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public abstract class AbstractSort {

    protected int[] baseArray = null;       //源数组
    protected int[] sortArray = null;       //排序数组
    protected int compareTimes = 0;         //比较次数
    protected int cycleTimes = 0;           //循环次数
    protected int changeTimes = 0;          //交换次数
    protected long startTime = 0;           //算法开始时间
    protected boolean isExchanged = true;

    AbstractSort(int[] array){
        this.baseArray = array;
    }

    /**
     * 属性初始化
     */
    protected void init(){
        sortArray = baseArray.clone();
        compareTimes = 0;
        cycleTimes = 0;
        changeTimes = 0;
        startTime = System.currentTimeMillis();
        isExchanged = false;
    }

    /**
     * 排序结果输出
     */
    protected void show(String desc){
        System.out.print(desc + "结果：");
        for (int i : sortArray) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(desc + "耗时："+(System.currentTimeMillis() - startTime));
        System.out.println(desc + "比较次数："+compareTimes);
        System.out.println(desc + "循环次数："+cycleTimes);
//        System.out.println(desc + "交换次数："+changeTimes);
    }

    /**
     * 排序方法
     */
    public abstract void sort();
}
