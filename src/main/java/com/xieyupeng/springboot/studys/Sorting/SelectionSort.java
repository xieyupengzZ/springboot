package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/13.
 * 选择排序，O(n) ~ O(n^2)，稳定
 *
 * 思想：
 * 每次都从0开始，相邻比较，大的往后放，如果逆序先记录到临时变量，直到全部比较完才把最大的数存到最后一位
 * 重复以上操作，直到把剩下的数里面最大的数保存到倒数第二位...
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
