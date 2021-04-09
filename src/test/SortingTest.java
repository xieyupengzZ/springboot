import com.xieyupeng.springboot.studys.Sorting.AbstractSort;
import com.xieyupeng.springboot.studys.Sorting.BubbleSort;
import com.xieyupeng.springboot.studys.Sorting.FastSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingTest {

    public static int[] sortArray = null;

    /**
     * 排序
     * @param list 所有的排序类
     */
    public static void sort(List<AbstractSort> list){
        for (AbstractSort abstractSort : list) {
            abstractSort.sort();
        }
    }

    /**
     * 初始化数组
     * @param num    数组长度
     * @param random 随机数范围
     */
    public static void initArray(int num,int random){
        sortArray = new int[num];
        Random r = new Random();
        for(int i = 0 ; i < num ; i ++){
            sortArray[i] = r.nextInt(random);
        }

        System.out.print("初始数组：");
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void initArray(int [] array){
        sortArray = array;

        System.out.print("初始数组：");
        for (int i : sortArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        initArray(20,30);
//        initArray(new int[]{2,4,5,0,1,2,8,9});

        List<AbstractSort> list = new ArrayList<AbstractSort>();
//        list.add(new BubbleSort(sortArray));
        list.add(new FastSort(sortArray));
        sort(list);
    }
}
