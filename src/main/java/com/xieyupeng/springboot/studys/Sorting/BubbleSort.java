package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/12.
 * 冒泡排序，O(n) ~ O(n^2)，稳定排序
 * 第一个比较到最后一个，比较一次交换一次位置，得到最小/大的数，存在数组最后一位；
 * 第一个比较到倒数第二个，比较一次交换一次位置，得到第二小/大的数，存在数组倒数第二位；以此类推；
 * <a>http://www.cnblogs.com/skywang12345/p/3596232.html</a>
 */
public class BubbleSort {

    private int[] array = null;
    private int comparisonTimes= 0;

    BubbleSort(int[] array){
        this.array = array;
    }


    public void sort(){

        if(array!=null&&array.length>0){
            long time1 = System.currentTimeMillis();
            for (int i = array.length ; i > 0 ; i --){ //用来控制比较的最后的位置

                for (int j = 0 ; j < i-1 ; j ++ ){

                        if(array[j]>array[j+1]){

                            comparisonTimes++;
                            int com = array[j+1];
                            array[j+1] = array[j];
                            array[j] = com;

                        }
                }
            }
            System.out.println("耗时："+(System.currentTimeMillis()-time1));
        }else {
            System.out.println("array is null");
        }
    }

    //优化后
    public void sortOptimize(){
        comparisonTimes = 0;
        boolean isExchanged = false;
        if(array!=null&&array.length>0){

            long time1 = System.currentTimeMillis();
            for (int i = array.length ; i > 0 ; i --){

                for (int j = 0 ; j < i-1 ; j ++ ){

                    if(array[j]>array[j+1]){

                        comparisonTimes ++;
                        int com = array[j+1];
                        array[j+1] = array[j];
                        array[j] = com;

                        isExchanged = true;
                    }

                }
                if(!isExchanged){ //如果第一次循环没有交换过，就说明是有序的，后面就不用比较了
                    System.out.println("第一遍循环就发现是有序的，不用比较啦，浪费我时间");
                    break;
                }
            }
            System.out.println("耗时："+(System.currentTimeMillis()-time1));
        }else {
            System.out.println("array is null");
        }
    }

    public void show(){
        System.out.println("交换了 "+comparisonTimes+" 次");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8,7,6,5,4,3,2,1,0};
        BubbleSort bubbleSort = new BubbleSort(array);
//        bubbleSort.sort();
        bubbleSort.sortOptimize();
        bubbleSort.show();
    }

}
