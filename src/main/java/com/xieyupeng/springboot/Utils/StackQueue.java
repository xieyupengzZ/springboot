package com.xieyupeng.springboot.Utils;

import java.io.*;
import java.util.Stack;

/**
 * Created by XYP on 2018/3/27.
 * 用栈的基本操作（push,pop,peek,empty）实现简单队列（add,offer,remove,poll,element,peek)
 */
public class StackQueue<T> {

    private Stack<T> stack1; //一个负责增加（栈底就是队列的头，栈顶就是队列的尾）
    private Stack<T> stack2; //一个负责删除（把stack1倒过来，取栈顶的元素，就实现了取出队列的头部）
    private int count;

    public StackQueue(){
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
        count = 0;
    }

    //增加
    public void add(T t){
//        if(stack1.empty()){ //这层判断有点多余，因为两者不可能同时有数据，只需要判断其中一个。加这层逻辑，方便思考。
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
//        }
        stack1.push(t);
        count++;
    }

    //删除并返回队列头部
    public T remove(){
//        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
//        }
        T t = stack2.pop();
        count--;
        return t;
    }

    public int size(){
        return count;
    }

    public static void main(String[] args) {

        try {
            //执行对象的序列化
            Integer i = 4;
            ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteOS);
            oos.write(i); //把 对象i 序列化到 byteOS 中
            byte[] bytes = byteOS.toByteArray();

            //再执行反序列化（bytes 在反序列化之前，一定要保证是通过ObjectOutputStream序列化的得到的，否则会报错 java.io.StreamCorruptedException: invalid stream header:）
            ByteArrayInputStream byteAI = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(byteAI);
            Object object = ois.readObject();//从输入流中读取出对象，反序列化
            System.out.println((int)object);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
