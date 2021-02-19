package com.xieyupeng.springboot.studys.Utils;

/**
 * Created by XYP on 2018/4/13.
 * 选择排序
 * 时间复杂度：O(n^2)
 * 稳定的算法
 * <a>http://www.cnblogs.com/skywang12345/p/3597641.html</a>
 */
public class SelectionSort {

    static void sort(int[] array){

        for(int i = 0 ; i < array.length-1; i ++){

            int max = 0;
            int maxIndex = 0;
            int j = i;

            for(;j < array.length ; j ++){
                if(array[j]>max){
                    max = array[j];
                    maxIndex = j;
                }
            }

            array[maxIndex] = array[i];
            array[i] = max;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,5,4,8,7,9,10};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
     }

}
