package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/12.
 * 快速排序，O(N*log2N) ~ O(N^2) (树的深度lgN ~ N)，不稳定的排序
 * 实现：
 * 选择一个比较数，把比它小的和比它大的分成两组，然后每组再分别选一个比较数，用这样的方法递归
 *
 * lg是以10为底，ln是以e为底
 * log级别的时间复杂度都是由于使用了分治思想,这个底数直接由分治的复杂度决定，二分法以2为底数,三分法以3为底数。
 *
 * 冒泡、选择、插入排序需要两个for循环，每次只关注一个元素，平均时间复杂度为O(n^2),一遍找元素O(n)，一遍找位置O(n)
 * 快速、归并、希尔、堆基于二分思想，log以2为底，平均时间复杂度为O(nlogn)O(nlogn),一遍找元素O(n)，一遍找位置O(logn)
 *
 * 比较算法的优劣看的是基本的操作次数：循环次数，比较次数，交换次数(赋值次数) 等。
 * 影响程度：循环操作 > 比较操作 > 赋值操作
 *
 * <a>http://www.cnblogs.com/skywang12345/p/3596746.html</a>
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
