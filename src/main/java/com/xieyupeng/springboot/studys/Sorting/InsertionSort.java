package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/12.
 * 插入排序:
 *      把无序的元素插入有序的集合，一般把第一个元素当做一个有序集合，从第二个开始比较插入
 *
 * 直接插入，O(n) ~ O(n^2)，稳定的排序
 * 希尔排序，O(n) ~ O(n^2)，不稳定的排序（相同的元素，分到不同的组）
 *      按某个间隔分组，如：按间隔2分组，1,3,5,7是一组，2,4,6,8是一组
 *      这个间隔每次递归都减1，直到最后间隔为1，进行一个直接插入排序，不过在基本有序的情况下，直接插入排序效率很高
 *
 * 希尔排序的时效分析很难，依赖于增量因子的选择，目前还没有最好的增量因子计算方法
 * <a>http://www.cnblogs.com/skywang12345/p/3596881.html</a>
 */
public class InsertionSort {

    //比较完了，一起移动
    static void sort(int[] array){

        for(int i = 1; i < array.length ; i ++){

            //TODO 给array[i]寻找合适的位置
            int j = i-1;
            for(; j >=0 ; j--){ //如果找不到满足的，就说明array[i] 是最小的，循环到最后，j 的值就是 -1
                if(array[j]<array[i]){
                    break;
                }
            }

            //TODO 找到位置后，插入，必要的话，需要移动参数
            if(j!=i-1){ //如果 i 和 j 相差 1，就表示两者相邻，不需要交换了

                //array[j] 是大于的那个数，所以移动是发生在它之后的，整体往后移动一位，截止到array[i]，把array[i]先临时   保存起来，因为会被覆盖。
                int comp = array[i];
                int k = i-1;
                for(; k > j ; k --){
                    array[k+1] = array[k];
                }
                array[k+1] = comp; //循环到最后，k 会 多减一次

            }

        }
    }

    //边比较，边移动
    public static void insertSort(int... array) {
        int length = array.length;
        // 此循环从1开始，就是将0下标的元素当做一个参照
        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {
                int vacancy = i; // 用于记录比较过程中那个空缺出来的位置
                int sentry = array[i]; // 比较值
                // 这个循环很关键，从当前下标之前一个元素开始倒序遍历，比较结果如果比当前大的，就后移
                //因为前面都是有序的，所以移动的时候，一定是循环一次移动一个
                for (int j = i - 1; j >= 0 && array[j] > sentry; j--) {
                    vacancy = j;
                    array[j + 1] = array[j]; // 后移比当前元素大的元素
                }
                array[vacancy] = sentry; // 将比较值，也就是当前下标对应的值置入空缺出来的位置
            }
        }
    }

    //希尔排序
    static void hillSort(int[] array, int gap){

        for(;gap>0;gap/=2) { //间隔不断减少至1

            for (int s = 0; s < gap; s++) { //每次同一间隔的循环中，起始位置都是 0 到 [gap-1] 之间，即每次都分成了gap组

                for (int i = s + gap; i < array.length; i += gap) {

                    //TODO 给array[i]寻找合适的位置
                    int j = i - gap;
                    for (; j >= s; j -= gap) { //如果找不到满足的，就说明array[i] 是最小的，循环到最后，j 的值就是 -gap
                        if (array[j] < array[i]) {
                            break;
                        }
                    }

                    //TODO 找到位置后，插入，必要的话，需要移动参数
                    if (j != i - gap) { //如果 i 和 j 相差 1，就表示两者相邻，不需要交换了

                        //array[j] 是大于的那个数，所以移动是发生在它之后的，整体往后移动一位，截止到array[i]，把array[i]先临时   保存起来，因为会被覆盖。
                        int comp = array[i];
                        int k = i - gap;
                        for (; k > j; k -= gap) {
                            array[k + gap] = array[k];
                        }
                        array[k + gap] = comp; //循环到最后，k 会 多减一次

                    }

                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,3,1,2,34,10,8,3,21,10,9};
//        sort(array);
//        insertSort(array);
        hillSort(array,array.length/2);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

}
