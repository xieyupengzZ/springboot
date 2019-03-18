package com.xieyupeng.springboot.Others;

import javafx.beans.property.DoubleProperty;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.*;

/**
 * java8 函数式编程
 */
public class FunctionalInterface {

    public static void main(String[] args){

        FileFilterTest();

    }

    //TODO 1 java.lang.Runable
    public void RunableTest(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("java.lang.Runable");
            }
        }).start();
        //lambda
        new Thread(() -> System.out.println("java.lang.Runable")).start();
    }

    //TODO 2 java.util.Comparator
    public void ComparatorTest(){
        CompareInnerTest test1 = new CompareInnerTest(0);
        CompareInnerTest test2 = new CompareInnerTest(1);
        List<CompareInnerTest> list = new ArrayList<CompareInnerTest>();
        list.add(test1);
        list.add(test2);
        Collections.sort(list,new Comparator<CompareInnerTest>(){
            @Override
            public int compare(CompareInnerTest o1, CompareInnerTest o2) {
                return o1.num - o2.num;
            }
        });
        //lambda（有返回值的 -> 后面直接写结果表达式）
        Collections.sort(list,(o1,o2) -> o1.num - o2.num);
    }

    //TODO 3 java.util.concurrent.Callable
    public void CallableTest(){
        new Thread(new FutureTask<String>(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return "java.util.concurrent.Callable";
                    }
                }
        )).start();
        //lambda（有返回值的 -> 后面直接写结果表达式）
        new Thread(new FutureTask<String>(() -> "java.util.concurrent.Callable")).start();
    }

    //TODO 4 java.io.FileFilter
    public static void FileFilterTest(){
        File filePath = new File("D:\\IDEA.project\\myhome\\src\\test\\resources\\fileTest");
        File[] files = filePath.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".txt");
            }
        });
        //lambda
        files = filePath.listFiles((File file) -> file.getName().endsWith(".txt"));
        Arrays.stream(files).forEach(file -> System.out.println(file));
    }

    //TODO 5 java.util.Function
    public static void FunctionTest(){

        //TODO 泛型控制
        // <T,U> - void
        BiConsumer<String,String> biConsumer           = (String s1, String s2) -> {} ;
        // <T>   - void
        Consumer<Byte> charConsumer                    = (Byte b1) -> {};
        // <T,U> - <R>
        BiFunction<Integer,Integer,Integer> biFunction = (Integer i1,Integer i2) -> i1 - i2;
        // <T>   - <R>
        Function<Short,Integer> function               = (Short st1) -> (int)st1;
        // <T,T> - <T>
        BinaryOperator<Float> binaryOperator           = (Float i1,Float i2) -> i1 - i2;
        // <T>   - <T>
        UnaryOperator<Object> unaryOperator            = (Object o1) -> new Object();

        //TODO 空参
        // ()     - <R>
        Supplier<Object> supplier                      = () -> new Object();
        // ()     - int
        IntSupplier intSupplier                        = () -> 1;
        // ()     - long
        LongSupplier longSupplier                      = () -> 1L;
        // ()     - double
        DoubleSupplier doubleSupplier                  = () -> 3D;
        // ()     - boolean
        BooleanSupplier booleanSupplier                = () -> true;

        //TODO double入参
        // <T> douible   - void
        ObjDoubleConsumer<Object> objDoubleConsumer    = (Object o,double d) -> {};
        // double double - double
        DoubleBinaryOperator doubleBinaryOperator      = (double d1,double d2) -> d1 - d2;
        // double        - void
        DoubleConsumer doubleConsumer                  = (double d1) -> {};
        // double        - <R>
        DoubleFunction<Object> doubleDoubleFunction    = (double d1) -> (float)d1;
        // double        - int
        DoubleToIntFunction doubleToIntFunction        = (double d1) -> 1;
        // double        - long
        DoubleToLongFunction doubleToLongFunction      = (double d1) -> 1L;
        // double        - double
        DoubleUnaryOperator doubleUnaryOperator        = (double d1) -> d1;
        // double        - boolean
        DoublePredicate doublePredicate                = (double d1) -> false;

        //TODO long入参
        // <T> long  - void
        ObjLongConsumer<Object> objectObjLongConsumer  = (Object o,long i) -> {};
        // long long - long
        LongBinaryOperator longBinaryOperator          = (long l1,long l2) -> l1 - l2;
        // long      - void
        LongConsumer longConsumer                      = (long l) -> {};
        // long      - <R>
        LongFunction<Object> longFunction              = (long l) -> (double)l;
        // long      - boolean
        LongPredicate longPredicate                    = (long l) -> true;
        // long      - double
        LongToDoubleFunction longToDoubleFunction      = (long l) -> (double)l;
        // long      - long
        LongUnaryOperator longUnaryOperator            = (long l) -> l;
        // long      - int
        LongToIntFunction longToIntFunction            = (long l) -> (int)l;


        //TODO int入参
        // <T> int - void
        ObjIntConsumer<Object> objectObjIntConsumer    = (Object o,int i) -> {};
        // int int - int
        IntBinaryOperator intBinaryOperator            = (int i1,int i2) -> i1 + i2;
        // int     - void
        IntConsumer intConsumer                        = (int i) -> {};
        // int     - <R>
        IntFunction<Object> intFunction                = (int i) -> i + "x";
        // int     - boolean
        IntPredicate intPredicate                      = (int i) -> false;
        // int     - double
        IntToDoubleFunction intToDoubleFunction        = (int i) -> (double) i;
        // int     - long
        IntToLongFunction intToLongFunction            = (int i) -> (long)i;
        // int     - int
        IntUnaryOperator intUnaryOperator              = (int i) -> i;

        //TODO 返回固定类型
        // <T,U>   - boolean
        BiPredicate<Object,Object> biPredicate         = (Object o1,Object o2) -> o1.equals(o2);
        // <T>     - boolean
        Predicate<Object> predicate                    = (Object o) -> true;
        // <T>     - double
        ToDoubleFunction<Object> toDoubleFunction      = (Object o) -> 1D;
        // <T,U>   - double
        ToDoubleBiFunction<Object,Object> toDoubleBi   = (Object o1,Object o2) -> 1D;
        // <T>     - long
        ToLongFunction<Object> toLongFunction          = (Object o) -> 1L;
        // <T,U>   - long
        ToLongBiFunction<Object,Object> toLongBi       = (Object o1,Object o2) -> 1L;
        // <T>     - int
        ToIntFunction<Object> toIntFunction            = (Object o1) -> 1;
        // <T,U>   - int
        ToIntBiFunction<Object,Object> toIntBiFunction = (Object o1,Object o2) -> 1;

    }


    public static class CompareInnerTest{

        int num;

        public CompareInnerTest(int num) {
            this.num = num;
        }
    }

}
