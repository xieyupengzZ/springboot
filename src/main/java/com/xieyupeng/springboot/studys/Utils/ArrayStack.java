package com.xieyupeng.springboot.studys.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYP on 2018/3/27.
 * 通过数组来实现栈
 * java.util.Stack //java中自带的栈集合
 */
public class ArrayStack<T> {

    private T[] array;
    private int count;
    private static int DEFAULT_SIZE = 16;//Array.newInstance方法调用了该参数，所以必须是静态

    public ArrayStack(Class<T> type){
        this(type,DEFAULT_SIZE);
    }

    public ArrayStack(Class<T> type,int size){
        this.count = size;
//        this.array = new T[size]; //这样不行
        this.array = (T[]) Array.newInstance(type,size); //通过反射,size是数组的最大容量
        count=0;
    }

//  push、pop、peek
    public void pushStack(T t){
        //以下可以看成两步
        //array[count] = t;
        //count++;
        //因为count++ 是先使用count，然后在++
        array[count++] = t;
    }

    public T peekStack(){
        if(count<=0){
            throw new IndexOutOfBoundsException();
        }
        return array[count-1];
    }

    public T popStack(){
        if(count<=0){
            throw new IndexOutOfBoundsException();
        }
        T t = array[count-1];
        count --;
        return t;
    }

    public int getSize(){
        return count;
    }

    public void removeByIndex(int index){
        int x = count - index - 1;
        System.arraycopy(array,index,array,index,x);//java.util.stack中删除某个节点的方法，貌似不生效？待研究
        array[count-1] = null;
    }

    public static void main(String[] args) {

        ArrayStack<String> arrayStack = new ArrayStack(String.class);
        arrayStack.pushStack("我");
        arrayStack.pushStack("是");
        arrayStack.pushStack("谢");
        arrayStack.pushStack("宇");
        arrayStack.pushStack("鹏");
//        arrayStack.removeByIndex(3);
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.popStack());
        System.out.println(arrayStack.peekStack());

    }
}
