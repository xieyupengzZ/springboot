package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/13.
 * 选择排序，O(n) ~ O(n^2)，稳定
 * 第一个比较到最后一个，得到最小/大的数，交换一次，存在数组最后一位；
 * 第一个比较到倒数第二个，得到第二小/大的数，交换一次，存在数组倒数第二位；以此类推；
 *
 * 与冒泡排序的区别就在于，冒泡是循环一次就交换很多次，选择是循环一次只交换一次
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
