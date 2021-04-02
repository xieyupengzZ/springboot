package com.xieyupeng.springboot.studys.Sorting;

/**
 *
 * Created by XYP on 2018/4/12.
 * 快速排序，O(N*log2N) ~ O(N^2) (树的深度log2N ~ N)，不稳定排序，交换排序
 *
 * 思想：
 * 选择一个比较数，把比它小的和比它大的分成两组，然后每组再分别选一个比较数，用这样的方法递归
 *
 *
 */
public class FastSort {

    int[] array = null; //不写修饰符，也就是默认（default），只有 同一个类 和 同包 能访问）
    static int comparisonTimes= 0;

    FastSort(int[] array){
        this.array = array;
    }

    //以数组第一个数为基数
    public static void sort(int[] array, int start,int end){
        System.out.println("循环开始：start = "+start+" end = "+end);

        if(end > start){

            int sindex = start;
            int eindex = end;
            int comparisonVal = array[sindex];
            while (sindex < eindex){

                //从右往左比较
                while ( eindex > sindex && array[eindex] >= comparisonVal){
                    eindex--;
                }
                if(eindex > sindex){
                    array[sindex] = array[eindex];
                    System.out.println(eindex+" 和 "+sindex + "交换");
                }

                //从左往右比较
                while ( eindex > sindex && array[sindex] <= comparisonVal){
                    sindex++;
                }
                if(eindex > sindex){
                    array[eindex] = array[sindex];
                    System.out.println(sindex+" 和 "+eindex + "交换");
                    eindex--;
                }
            }
            System.out.println("循环结束：start = "+sindex + " end = "+eindex);

            array[sindex] = comparisonVal;
            //注意必须以上一次的开始结束作为标准
            sort(array,start,sindex-1);
            sort(array,sindex+1,end);
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{3,2,5,12,7,9,3,1,4,0,0,2};
        sort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
