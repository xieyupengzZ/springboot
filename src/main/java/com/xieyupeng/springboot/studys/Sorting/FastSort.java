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
        init();
        sort1(sortArray,0,sortArray.length-1);
        show("快速排序1 ");

        init();
        sort2(arrayCopy,0,sortArray.length-1);
        show("快速排序2 ");
    }

    //以数组第一个数为基数
    public void sort1(int[] array, int start,int end){

        if (start < end){

            int sindex = start;
            int eindex = end;
            int comparisonVal = array[sindex];
            while (sindex < eindex){

                //从右往左比较
                while ( sindex < eindex && comparisonVal <= array[eindex]){
                    eindex--;
                }
                if(sindex < eindex){
                    array[sindex] = array[eindex];
                    System.out.println(eindex+" 和 "+sindex + "交换");
                }

                //从左往右比较
                while ( sindex < eindex  && array[sindex] <= comparisonVal){
                    sindex++;
                }
                if(sindex < eindex){
                    array[eindex] = array[sindex];
                    System.out.println(sindex+" 和 "+eindex + "交换");
                    eindex--;
                }
            }

            array[sindex] = comparisonVal;
            //剔除掉比较数，无需再比
            sort1(array,start,sindex-1);
            sort1(array,sindex+1,end);
        }

    }


    public void sort2(int[] array,int start,int end){

        if(start < end){

            int startCopy = start;
            int endCopy = end;
            int startIndex = start;
            int endIndex = end;
            boolean left = false;
            boolean right = false;
            int compareValue =  sortArray[start];
            while (startCopy < endCopy ){
                if(sortArray[++startCopy] <= compareValue){
                    array[startIndex++] = sortArray[startCopy];
                    left = true;
                }else{
                    array[endIndex--] = sortArray[startCopy];
                    right = true;
                }
            }

            //因为会多加一次，所以要减去
            endIndex = right ? endIndex+1 : endIndex ;
            if(left){
                startIndex--;
                array[startIndex+1] = compareValue;
            }else{
                array[startIndex] = compareValue;
            }

            //复制给原数组
            for(int index = start ; index <= end ; index ++ ){
                sortArray[index] = array[index];
            }

            for (int i : sortArray) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println();

            sort2(array,start,startIndex);
            sort2(array,endIndex,end);
        }
    }

}
