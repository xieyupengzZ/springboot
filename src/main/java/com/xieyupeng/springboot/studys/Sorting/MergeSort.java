package com.xieyupeng.springboot.studys.Sorting;

import org.json.JSONArray;
import org.json.JSONString;
import org.omg.CORBA.INTERNAL;

import javax.sound.midi.Soundbank;
import java.util.Random;

/**
 * 归并排序
 * 思想：相邻两个数比较形成一个有序集合，再把相邻的两个有序集合比较形成一个大集合，直到整个集合有序
 * 实现：
 * 1、迭代，从单元素开始合并
 * 2、递归，一直递归两分，直到元素的数量是1，再互相比较，再回调
 *    一个长度为n的数组，递归两分，直到元素个数是1，需要递归 2n -1 次
 */
public class MergeSort {

    private int[] array = null;     //原数组
    private int[] arrayCopy = null; //临时数组
    private static int rnum = 0;    //递归次数
    private static int comnum = 0;  //比较次数
    private static int gnum = 0;     //赋值次数
    private static int mnum = 0;    //合并方法中的循环次数

    public MergeSort(int[] array){
        this.array = array;
        this.arrayCopy = new int[array.length];
        rnum = 0;comnum = 0;gnum = 0;mnum = 0;
    }

    /**
     * 插入排序的方式合并，不需要额外数组
     * 右边插入左边
     */
    public void getSortDigui() {
        long starttime = System.currentTimeMillis();
        System.out.println();System.out.println();
        System.out.println("starttime : " + starttime);
        sortDigui(array, 0, array.length - 1);
        System.out.println("endtime : " + System.currentTimeMillis());
        System.out.println("usertime : " + (System.currentTimeMillis() - starttime));
        System.out.println("递归次数：" + rnum);
        System.out.println("比较次数：" + comnum);
        System.out.println("赋值次数：" + gnum);
        System.out.println("合并循环次数：" + mnum);
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 迭代方式合并，需要一个额外数组
     */
    public void getSortMappao(){
        long starttime = System.currentTimeMillis();
        System.out.println();System.out.println();
        System.out.println("starttime : " + starttime);
        sortMaopao(array,0,array.length-1,arrayCopy);
        System.out.println("endtime : " + System.currentTimeMillis());
        System.out.println("usertime : " + (System.currentTimeMillis() - starttime));
        System.out.println("递归次数：" + rnum);
        System.out.println("比较次数：" + comnum);
        System.out.println("赋值次数：" + gnum);
        System.out.println("合并循环次数：" + mnum);
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 递归方式合并，需要一个额外数组
     */
    public void getSort() {
        long starttime = System.currentTimeMillis();
        System.out.println();System.out.println();
        System.out.println("starttime : " + starttime);
        sort(array, 0, array.length - 1,arrayCopy);
        System.out.println("endtime : " + System.currentTimeMillis());
        System.out.println("usertime : " + (System.currentTimeMillis() - starttime));
        System.out.println("递归次数：" + rnum);
        System.out.println("比较次数：" + comnum);
        System.out.println("赋值次数：" + gnum);
        System.out.println("合并循环次数：" + mnum);
        for (int i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    /**
     * 迭代，自己写的
     */
    static void sortMaopao(int array[],int start,int end,int[] temp){

        int len = array.length;
        gnum++;
        //每次比较，单个数组中的元素个数,1,2,4,8...
        for(int i = 1 ; i < end ; i *= 2){
            rnum ++;comnum++;gnum++;
            //每次循环都是两个数组比较
            for(int sindex = 0 ; sindex < len; sindex+=i*2){
                rnum ++;comnum++;gnum++;
                //sindex 第一个数组的起始位置

                //mid，可以先计算第二个数组的起始位置，好理解
                //mid = sindex2-1
                int sindex2 = sindex + i;
                sindex2 = sindex2 > len - 1 ? len - 1 : sindex2;
                comnum++;gnum++;gnum++;
                //第二个数组的结尾
                int eindex = sindex + i*2 - 1;
                eindex = eindex > len - 1 ? len - 1: eindex;
                comnum++;gnum++;gnum++;
                //递归算法是先计算mid，根据mid一直两分到每个集合只剩一个，此时mid已全部定好，并且每次回调能保证每个mid两边的集合有序
                //迭代算法是正向的，根据元素个数循环，每次循环完都按元素个数分组且有序。下次循环元素个数倍增，重新按元素个数分组排序。
                //此时mid不能直接取开始和结束之间的中间位置，示例待排序数组,0,3,6,1,4,5。循环到第三次排序的时候，0,1,3,6已经有序，4,5也有序。
                //现在要合并这两个数组，如果直接取中间，mid就是2，这变成了合并 0,1,3 和 6,4,5 两个数组，归并排序合并的两个数组必须是有的，此处就乱了。
                //mid的取值必须依赖于每个数组的长度
                comnum++;
                if(sindex != eindex){ //只有一个数时就不用合并了
                    merge(array,sindex,sindex2-1,eindex,temp);
                }
            }
        }
    }

    /**
     * 递归，自己写的
     * @param array
     * @param start
     * @param end
     */
    static void sortDigui(int[] array,int start,int end){
        rnum ++;comnum++;
        if(end - start <= 1){
            if(array[start] > array[end]){
                int startdata = array[start];
                array[start] = array[end];
                array[end] = startdata;
            }
        }else{
            int mid = ( end + start ) / 2;
            sortDigui(array,start,mid);
            sortDigui(array,mid+1,end);
            mergeInsert(start,mid,end,array);
        }
    }

    /**
     * 递归，网上的
     */
    static void sort(int[] array,int start,int end,int[] temp){
        rnum ++;comnum++;
        if(start < end){
            int mid = (start + end) / 2;
            sort(array,start,mid,temp);
            sort(array,mid+1,end,temp);
            merge(array,start,mid,end,temp);
        }
    }

    /**
     * 插入排序方式合并，自己写的，慢T_T，原因如下
     */
    static void mergeInsert(int start,int mid,int end,int[] array){

        for(mid ++ ; mid <= end ; mid ++){
            mnum ++;
            //一旦在左边有序列表中找到比它大的就退出，此时start就是要交换的位置
            //满循环退出while时start要等于mid
            //第一种：
            while (array[start] <= array[mid]){
                comnum++;comnum++;
                if(++start==mid){
                    break;
                }
            }
            //第二种：
//            while (start < mid){
//                if(arrayCopy[start] > arrayCopy[mid]){
//                    break;
//                }
//                start++;
//            }

            gnum++;
            int midtemp = array[mid];
            //把start后面的数据都往后移动一位：陆续把前面的值赋值给后面的位置
            //mergeInsert方法大部分时间耗费在此处，每插入一位都要移动(赋值)很多次，数组随机时平均耗时比较高，O(n*n)*递归次数
            //merge方法一次性插入完存在临时数组里，然后一次性赋值给原来的数组，就不存在每次都要移位操作，O(n+n)*递归次数
            for(int m = mid;start < m ; m--){
                gnum++;comnum++;
                array[m] = array[m-1];
            }
            //把值插入start位置
            gnum++;
            array[start] = midtemp;
            //后续循环从start位置开始比较，因为右边也是有序集合，后面的数一定比前面的大，所以不用从头比较

        }
    }

    /**
     * 核心的就是合并算法，用的同一个，性能就差不多
     * 网上比较经典的合并方法，大部分都是参考这个
     * 两两比较，一方到头，另一方剩下全部赋值即可，需要临时数组
     * @param start 第一个数组的开始位置
     * @param mid 第一个数组的结束位置，两个相邻有序数组合并，两个数组长度可能不一致，所以mid很重要
     * @param end 第二个数组结束位置
     */
    static void merge(int[] array,int start,int mid,int end,int[] temp){
        gnum++;gnum++;gnum++;
        int left = start;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end){
            mnum++;
            comnum++;comnum++;gnum++;
            //哪边小哪边的索引就 ++ （++在后，先用再加）
            if (array[left] > array[right]) {
                temp[index++] = array[right++];
            } else {
                temp[index++] = array[left++];
            }
        }
        while (left <= mid){ //右边先到头
            mnum++;
            gnum++;comnum++;
            temp[index++] = array[left++];
        }
        while (right <= end){ //左边先到头
            mnum++;
            gnum++;comnum++;
            temp[index++] = array[right++];
        }
        for (index = 0; start <= end ; start ++,index++){
            gnum++;comnum++;
            array[start] = temp[index];
        }
    }

    public static void main(String[] args) {
        int num = 50000;
        int[] array = new int[num];
        Random r = new Random();
        for(int i = 0 ; i < num ; i ++){
            array[i] = r.nextInt(num);
            System.out.print(array[i]);
            System.out.print(" ");
        }
        MergeSort ms = new MergeSort(array);
        ms.getSortDigui();
        MergeSort ms2 = new MergeSort(array);
        ms2.getSort();
        MergeSort ms3 = new MergeSort(array);
        ms3.getSortMappao();

//        int[] array = new int[]{0,3,5,1,4,5};
//        MergeSort ms = new MergeSort(array);
//        merge(array,0,2,5,arrayCopy);
//        System.out.println();
//        for (int i : array) {
//            System.out.print(i);
//            System.out.print(" ");
//        }
    }


}
