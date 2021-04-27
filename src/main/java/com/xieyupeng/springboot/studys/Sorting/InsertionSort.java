package com.xieyupeng.springboot.studys.Sorting;

import com.xieyupeng.springboot.controller.UserTokenController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by XYP on 2018/4/12.
 *
 * 直接插入，O(n) ~ O(n^2)，稳定的排序
 * 思想：
 * 把无序的元素插入有序的集合，一般把第一个元素当做一个有序集合，从第二个开始比较插入
 * 优化：
 * 由于每次插入是向已排序数组中插入，可使用二分查找查找到相应位置进行插入.
 *
 *
 *  希尔排序，O(n) ~ O(n^2)，不稳定的排序（相同的元素，分到不同的组）
 * 思想：
 * 按某个间隔分组，如：按间隔2分组，1,3,5,7是一组，2,4,6,8是一组
 * 这个间隔每次递归都减1，直到最后间隔为1，进行一个直接插入排序，不过在基本有序的情况下，直接插入排序效率很高
 * 希尔排序的时效分析很难，依赖于增量因子的选择，目前还没有最好的增量因子计算方法
 *
 * <a>http://www.cnblogs.com/skywang12345/p/3596881.html</a>
 */
public class InsertionSort extends AbstractSort{

    public InsertionSort(int[] array){
        super(array);
    }

    @Override
    public void sort() {

//        init();
//        sort1(sortArray);
//        show("插入排序1 ");
//        System.out.println();

        init();
        sort2(sortArray);
        show("插入排序2 ");
        System.out.println();

        init();
        sort3(sortArray);
        show("插入排序3 ");
        System.out.println();


    }

    /**
     * 直接插入排序
     * 值的比例 约等于 索引(位置)的比例，能快速定位到最近位置，然后再依次比较
     * 比较次数比sort2少，但是耗时比sort2长，因为计算花时间了
     * 此处只是简单比较大小，如果某个业务中，比较是一个复杂操作，减少比较次数的收益就比较高了
     */
    public void sort1(int[] array){

        int len = array.length;
        int index = 1;
        while (index < len){
            compareTimes++;
            cycleTimes++;
            //已排好序的数组长度
            int compare = array[index];
            int sortLen = index;

            //有序数组中查找插入的位置，数值大小比例 和 索引比例 差不多
            //array[sortIndex] - array[0] / array[sortLen-1] - array[0] == sortIndex - 0 / sortLen - 0
            //注意越界，如：2200多个数排序，每个数取值范围10万以内，那么计算结果就可能超过21亿，大于int的最大值，改用long
            long sortIndex = 0;
            if(array[sortLen-1] - array[0] != 0){
                sortIndex =  sortLen * (array[index] - array[0]) / (array[sortLen-1] - array[0]);
            }

            //插入位置大于等于有序数组长度，就直接退出，并指向下一个比较数
            compareTimes++;
            if(sortIndex >= sortLen){
                index ++;
                continue;
            }

            //插入的位置小于0，就交换到第一位
            compareTimes++;
            if(sortIndex < 0){
                while (sortLen > 0){
                    compareTimes++;
                    cycleTimes++;
                    changeTimes++;
                    array[sortLen] = array[sortLen-1];
                    sortLen--;
                }
                changeTimes++;
                array[0] = compare;
                index++;
                continue;
            }


            //大于等于往后找
            compareTimes++;
            if(array[(int) sortIndex] <= compare){
                while (sortIndex < sortLen && array[(int) sortIndex] <= compare){
                    compareTimes+=2;
                    cycleTimes++;
                    sortIndex ++;
                }
                //如果插入位置不是在最后，就把前面的先移位，从sortIndex到sortLen-1，每一个都往后移一位
                compareTimes++;
                if(sortIndex < sortLen){
                    while (sortLen > sortIndex){
                        compareTimes++;
                        cycleTimes++;
                        changeTimes++;
                        array[sortLen] = array[sortLen-1];
                        sortLen--;
                    }
                }
                //赋值
                changeTimes++;
                array[(int) sortIndex] = compare;

            }else {//小于往前找
                while (sortIndex > 0 && array[(int) sortIndex] > compare){
                    compareTimes+=2;
                    cycleTimes++;
                    sortIndex --;
                }
                //防止极端情况，如：比较数比第二个数小但是比第一个数大，循环结束得到的插入位置是0，其实应该是1
                if(array[(int) sortIndex] <= compare){
                    sortIndex++;
                }
                //先移位，从sortIndex到sortLen-1，每一个都往后移一位
                while (sortLen > sortIndex){
                    compareTimes++;
                    cycleTimes++;
                    changeTimes++;
                    array[sortLen] = array[sortLen-1];
                    sortLen--;
                }
                //赋值
                changeTimes++;
                array[(int) sortIndex] = compare;
            }

            //下一个比较数
            index ++;
        }
    }

    /**
     * 直接插入排序
     * 逐个比较，边比较边移位，减少循环次数；
     * 如果是先找出位置，最后再一起移位，还需再循环一遍。
     * @param array
     */
    public void sort2(int[] array){
        int index = 1;
        while (index < array.length){
            compareTimes+=2;
            cycleTimes++;
            if(array[index] >= array[index-1]){
                index++;
                continue;
            }
            int insertIndex = index;//插入的位置
            int compare = array[index];//比较值

            while (insertIndex > 0 && array[insertIndex - 1] > compare){
                compareTimes+=2;
                cycleTimes++;
                array[insertIndex] = array[insertIndex - 1];
                insertIndex -- ;
            }
            array[insertIndex] = compare;
            index ++;
        }
    }


    /**
     * 希尔排序
     * 单组中比较时，边比较边移位。
     */
    public void sort3(int[] array){
        int gap = array.length / 2;
        while (gap > 0){ //控制间隔的变化，初始化为数组长度的一半，2倍递减
            compareTimes++;
            cycleTimes++;
            int gapindex = 0;
            while (gapindex < gap){ //控制起始位置的变化，从0到gap-1，一共gap-1组，[0,gap,gap*2...]，[1,gap+1,gap*2+1...]，[2,gap+2,gap*2+2...]...[gap-1,gap*2-1,gap*3-1...]
                compareTimes++;
                cycleTimes++;
                /** 从此处开始，本质就是一个直接插入排序（直接插入排序的gap=1），可对比sort2方法**/
                int insert = gapindex + gap;//insert就是每次准备要插入的数的位置
                while (insert < array.length ){
                    compareTimes+=2;
                    cycleTimes++;
                    if(array[insert] >= array[insert-gap]){
                        insert += gap;
                        continue;
                    }
                    int insertIndex = insert;
                    int temp = array[insert];

                    while ( insertIndex - gap >= 0 &&  array[insertIndex - gap] > temp ){
                        compareTimes+=2;
                        cycleTimes++;
                        array[insertIndex] = array[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    array[insertIndex] = temp;
                    insert += gap;
                }
                /**----------------------------------------------------------**/
                gapindex ++;
            }
            gap /= 2;
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


}
