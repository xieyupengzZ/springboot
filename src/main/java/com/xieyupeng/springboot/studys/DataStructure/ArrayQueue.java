package com.xieyupeng.springboot.studys.DataStructure;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * Created by XYP on 2018/3/27.
 * 用数组实现简单队列
 */
public class ArrayQueue<T> {

    private T[] array;
    private static int DEFAULT_SIZE = 16;
    private int count;

    public ArrayQueue(Class<T> type){
        this(type,DEFAULT_SIZE);
    }

    public ArrayQueue(Class<T> type,int size){
        array = (T[]) Array.newInstance(type,size);
        count=0;
    }

    //入
    public void enter(T t){
        array[count++] = t;
    }

    //出,只能从队列头部拿出
    public T out(){
        if(count<=0){
            throw new ArrayIndexOutOfBoundsException();
        }
        T t = array[0];
        count--;
        for(int i = 0 ; i < count ; i ++){
            array[i] = array[i+1];
        }
        array[count]=null;
        return t;
    }

    public int size(){
        return count;
    }

    public T last(){
        return array[count-1];
    }

    public void show(){
        for (T t : array) {
            System.out.print(t);
        }
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(Integer.class);
        arrayQueue.enter(1);
        arrayQueue.enter(2);
        arrayQueue.enter(3);
        arrayQueue.enter(4);
        System.out.println(arrayQueue.out());
        arrayQueue.show();
        System.out.println();
    }

    java.util.LinkedList<String> list = new LinkedList<String>();

}
