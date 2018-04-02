package com.xieyupeng.springboot;

/**
 * Created by XYP on 2018/1/15.
 */
public class ClassTest {
    public static void main(String[] args)
    {
        staticFunction(); //TODO 执行main函数，出发类的初始化
    }

    static
    {
        System.out.println("1");//TODO static修饰的，都是按代码的顺序执行
    }

    static ClassTest st = new ClassTest(); //TODO 初始化对象（先属性赋值，再代码块，再构造方法）

    static
    {
        //TODO 第三个static修饰的，第三个执行，此处看下b的值，也就能知道 b的赋值操作没有执行（此处直接调用 b 编译不通过，要通过st来调用，因为st已经初始化了）
        System.out.println("2:"+st.b);
    }

    {
        System.out.println("3:"); //TODO 初始化st的时候，执行了该代码块
    }

    //TODO 初始化st的时候，最后执行构造方法，a已经有值了，b 是 static 修饰的，要按照 statcic 修饰所有对象的顺序来执行，所有没有值。
    //TODO 但是在准备阶段，已经把所有的属性都初始化了，根据类型默认为0，只是没有执行赋值操作。（加载→验证→准备→解析→初始化→）。
    ClassTest()
    {
        System.out.print("4:");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){ //TODO 最后执行调用的函数
        System.out.println("5:"+b);
    }

    int a =110; //TODO 初始化st的时候，首先对a赋值
    static int b = 112; //TODO 第四个static修饰的，第四个执行

    static
    {
        //TODO 第五个static修饰的，第五个执行，此处看下b的值，也就能知道 b的赋值操作执行了
        //TODO 静态代码块，想要使用变量，必须是在它前面定义的；但是赋值操作没有前后限制
        System.out.println("6:"+b);
    }
}
