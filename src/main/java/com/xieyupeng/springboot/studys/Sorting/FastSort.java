package com.xieyupeng.springboot.studys.Sorting;

/**
 * Created by XYP on 2018/4/12.
 * 快速排序，O(N*log2N) ~ O(N^2) (树的深度log2N ~ N)，不稳定排序，交换排序
 *
 * 思想：
 * 选择一个比较数，把比它小的和比它大的分成两组，然后每组再分别选一个比较数，用这样的方法递归
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
        System.out.println();

        init();
        sort2(arrayCopy,0,sortArray.length-1);
        show("快速排序2 ");
        System.out.println();

        init();
        sort3(sortArray,0,sortArray.length-1);
        show("快速排序3 ");
        System.out.println();
    }

    /**
     * 不是使用额外数组
     * 把第一个数当做比较数
     * 第一次：从头开始找大的，找到后记下位置，把该数放到比较数的位置上；从尾开始找小的，找到后记下位置，把该数放到前一个记下的位置上
     */
    public void sort1(int[] array, int start,int end){


        if (start < end){
            compareTimes++;

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

        if(start < end){
            compareTimes++;

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
            //2、全部比比较数小，那么尾部就是剩下的位置（left==true right==false）
            //2、全部比比较数大，那么头部就是剩下的位置（right==true left==false）
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

    /**
     * 不使用额外数组
     * 比较两次，交换一次；每次找到大于等于或小于等于的
     *
     * 实现逻辑：
     * 把第一个数当做比较数
     * 第一次：从头开始找 >= 的，就找到第一个数(比较数)；再从尾开始找到 <= 的；交换两者，小的放到前面，比较数就放到后面了；
     * 第二次：从前面开始找 >= 的；再从尾部开始找 <= 的，又找到了比较数；交换两者，比较数放到前面，大的放到后面了；
     * 第三次：从前面开始找 >= 的，又是比较数；以此类推。。。
     *
     * 每次循环找到的两个数中总有比较数(第一个数)。第一个数就这样从左交换到右又交换到左。。。反复交换直到最后一个中间的位置上。
     */
    public void sort3(int[] array,int start,int end) {

        //把第一个数作为比较数
        int pivot = array[start];
        int s = start;
        int e = end;
        while ( s < e ) {
            cycleTimes++;
            compareTimes++;

            //从后面开始找，找到 >=pivot 的
            while ( s < e && pivot < array[e] ) {
                cycleTimes++;
                compareTimes+=2;
                e--;
            }

            //从前面开始找，找到 <=pivot 的
            while ( s < e && array[s] < pivot ) {
                cycleTimes++;
                compareTimes+=2;
                s++;
            }

            //两数相等时(都等于比较数，因为两者中必有一个是比较数)
            //左边的索引+1，继续找大的，右边的不动，是为了把右边的移到左边，因为排序方式是左边小右边大
            if ( array[s]==array[e] && s < e ) {
                compareTimes+=2;
                s++;

            } else { //交换二者的位置，小的到前，大的到后
                int temp = array[s];
                array[s] = array[e];
                array[e] = temp;
            }
        }
        //退出循环的时候s=e，s-1和e+1之间的就是比较数
        if (s-1>start) sort3(array,start,s-1);
        if (e+1<end) sort3(array,e+1,end);
    }

}
