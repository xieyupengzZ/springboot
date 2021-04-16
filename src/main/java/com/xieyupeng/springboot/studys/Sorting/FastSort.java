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
public class FastSort extends AbstractSort{

    int[] arrayCopy = null;

    public FastSort(int[] array){
        super(array);
        arrayCopy = new int[array.length];
    }

    @Override
    public void sort() {
        System.out.println();
        init();
        sort1(sortArray,0,sortArray.length-1);
        show("快速排序1 ");

        System.out.println();
        init();
        sort2(arrayCopy,0,sortArray.length-1);
        show("快速排序2 ");
    }

    /**
     * 不是使用额外数组，有问题 TODO
     */
    public void sort1(int[] array, int start,int end){

        compareTimes++;
        if (start < end){

            int sindex = start;
            int eindex = end;
            int comparisonVal = array[sindex];
            while (sindex < eindex){
                compareTimes++;
                cycleTimes++;
                //从尾部开始比较，找到小的，放到头部去
                while ( sindex < eindex && comparisonVal <= array[eindex]){
                    compareTimes+=2;
                    cycleTimes++;
                    eindex--;
                }
                compareTimes++;
                if(sindex < eindex){
                    array[sindex++] = array[eindex];
                }

                //从头部开始比较，找到大的，放到尾部去
                while ( sindex < eindex  && array[sindex] <= comparisonVal){
                    compareTimes+=2;
                    cycleTimes++;
                    sindex++;
                }
                compareTimes++;
                if(sindex < eindex){
                    array[eindex--] = array[sindex];
                }
             }

            //把比较数放到最后一个移动了的位置上，这样一次循环中，所有需要移动的位置都归位，无需额外数组
            array[sindex] = comparisonVal;

            //剔除掉比较数array[sindex]，无需再比，否则可能发生死循环
            sort1(array,start,sindex-1);
            sort1(array,sindex+1,end);
        }

    }


    /**
     * 使用额外数组
     */
    public void sort2(int[] array,int start,int end){

        compareTimes++;
        if(start < end){

            int startCopy = start;
            int endCopy = end;
            int startIndex = start;
            int endIndex = end;
            boolean left = false;
            boolean right = false;
            int compareValue =  sortArray[start];

            while (startCopy < endCopy ){
                compareTimes+=2;
                cycleTimes++;
                //从第二位开始比较
                if(sortArray[++startCopy] <= compareValue){
                    //小于放头部，从第一位开始
                    array[startIndex++] = sortArray[startCopy];
                    left = true;

                }else{ //大于放尾部，从最后一位开始
                    array[endIndex--] = sortArray[startCopy];
                    right = true;
                }
            }

            //把比较数放在剩下的空位置上
            //1、小的从头部开始放，大的从尾部开始放，最后中间就是剩下的位置（left==true or right==true）
            //2、全部比比较数小，那么尾部就是剩下的位置（left==true）
            //2、全部比比较数大，那么头部就是剩下的位置（right==true）
            //第一种情况，循环结束，startIndex 会多加一位，endIndex 会多减一位，所以 startIndex 或 endIndex 正好就是中间的位置；
            //第二种情况，endIndex 就是剩下的位置；
            //第三种情况，startIndex 就是剩下的位置;
            if(left){
                array[startIndex] = compareValue;
                startIndex--;//因为多加一位，所以要减去，防止递归出错
            }
            if(right){
                array[endIndex] = compareValue;
                endIndex++;//因为多减一位，所以要加上，防止递归出错
            }

            //复制给原数组
            for(int index = start ; index <= end ; index ++ ){
                compareTimes++;
                cycleTimes++;
                sortArray[index] = array[index];
            }

            //startIndex 和 endIndex 之间的就是本次递归的比较数，剔除掉，无需再比，否则可能死循环
            sort2(array,start,startIndex);
            sort2(array,endIndex,end);
        }
    }

    public void srot3(int[] array,int start,int end) {
        int pivot = array[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(array[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(array[i]<pivot)) {
                i++;
            }
            if ((array[i]==array[j])&&(i<j)) {
                i++;
            } else {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        if (i-1>start) srot3(array,start,i-1);
        if (j+1<end) srot3(array,j+1,end);
    }
}
