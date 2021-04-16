package com.xieyupeng.springboot.studys.Sorting;

import java.util.Random;

/**
 *
 *  Created by XYP on 2018/4/12.
 * 冒泡排序，O(n) ~ O(n^2)，稳定排序，交换排序
 *
 * 思想：
 * 每次都从0开始，相邻比较，大的往后放，只要逆序就交换，直到最大的数保存在最后一位
 * 重复以上操作，把剩下的数里面最大的数保存到倒数第二位...
 *
 * 优化1：设置一个标志，每轮比较时，如果发现没有进行交换操作，说明数组已经有序，退出循环，停止比较
 * 优化2：在比较过程中记录下没有发生交换的区间，下次循环可直接跳过，减少不必要的比较
 *
 */
public class BubbleSort extends AbstractSort{

    public BubbleSort(int[] array){
        super(array);
    }

    public void sort(){

        System.out.println();
        sort1();
        show("冒泡排序1 ");

        System.out.println();
        sort2();
        show("冒泡排序2 ");
    }

    /**
     * 用一个交换标识来判断如果数组已经有序就退出循环
     */
    public void sort1(){

        init();
        long time1 = System.currentTimeMillis();

        //while循环的方法
        int index = 0;
        int len = sortArray.length;
        while (len-->0){
            index = 0;
            compareTimes++;
            while (index < len){
                cycleTimes ++;
                compareTimes++;
                if(sortArray[index] > sortArray[index+1]){
                    changeTimes++;
                    int val = sortArray[index+1];
                    sortArray[index+1] = sortArray[index];
                    sortArray[index] = val;
                    isExchanged = true;
                }
                index ++;
            }
            if(!isExchanged){
//                System.out.println("已经有序无需再比，结束位置 = " + len);
                break;
            }else{
                isExchanged = false;
            }
        }

    }

    /**
     * 在比较过程中记录下没有发生交换的区间，下次循环可直接跳过
     */
    public void sort2(){

        init();
        long time1 = System.currentTimeMillis();


        int index = 0;
        int end = sortArray.length;
        int right = 0;
        while (end-- > 0){
            index = 0;
            compareTimes++;
            while (index < end){
                cycleTimes ++;
                compareTimes++;
                if(sortArray[index] > sortArray[index+1]){
                    changeTimes++;
                    int val = sortArray[index+1];
                    sortArray[index+1] = sortArray[index];
                    sortArray[index] = val;
                    right = index + 1;
                    isExchanged = true;
                }
                index++;
            }
            //把本次循环中最后一个交换的位置当做下次循环的终点
            if(isExchanged){
                end = right;
                isExchanged = false;

                //如果没有交换说明已经有序，直接退出
            }else {
                break;
            }
        }

    }

}
