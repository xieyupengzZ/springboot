package com.xieyupeng.springboot.studys.Others;

/**
 * 基本数据类型
 */
public class BaseType {

    static boolean bl = false;  //1个bit位
    static byte    b = 1;       //1字节（-128 - 127）
    static char    c = 1;       //2字节（0 - 65535）
    static short   s = 1;       //2字节（-32768 - 32767）
    static int     i = 1;       //4字节（-2147483648 - 2147483647）
    static float   f = 1.0F;    //4字节（float的取值范围比long大）
    static long    l = 1L;      //8字节
    static double  d = 1.0;     //8字节（小数默认double）

    /**
     * char、byte、short 计算时，自动转成 int
     * (char\byte-short)-int-long-float-double；
     * 低等级和高等级计算，低级向高级自动转换；高低向低级转换要强制转换
     */
    public static void method1(){
        int io = b + c + s;          // 1 + 99(c的ASCII码) + 1
        float fo = i + l + f;        //低级自动向高级转换，表达式的结果是float型
        long lo = (long)(i + l + f); //高级强制向低级转换，float型赋值给long型
    }

    /**
     * 三目运算符【?:】，注意两个表达式的转换问题
     * 字符类型要注意，其他类型按照优先级自动转换即可
     */
    public static void method2(){

        //1 都是常量，按照自动类型转换的规则，字符和整数注意下
        System.out.println(true? 'c':1);//字符 和 整数 时，向 char 转换
        System.out.println(true? 126:'c');
        System.out.println(true? -1:'c');//字符 和 整数 时，整数超过char取值范围，结果是整数
        System.out.println(true? 'c':1.0);//字符 和 浮点型 时，向 浮点 转换
        System.out.println(true? 1.0:'c');
        //2 都是变量，按照自动类型转换的规则，字符和整数注意下
        char c = 'c';
        byte b = 1;
        System.out.println(true?c:b);
        //3 一个常量 一个变量，按照自动类型转换的规则，字符和整数注意下
        char c1 = 'c';
        System.out.println(true?c1:126);
        System.out.println(false?c1:126);
        byte b1 = 1;
        System.out.println(true?'c':b);
        //4 总结：两个表达式是 字符 和 整数
        //  无论[字符]是以变量还是常量的形式，只要另一个表达式整数是常量形式，并且取值范围在char范围内，三目表达式结果就按char转型
        //  如果另一个整数是以变量的形式，那么就按整数转型，无论字符是常量还是变量形式
    }

    /**
     * 位运算符（记住优先级！上面优先级高)
     * ~ 取反
     * & 都1，就为1，否则为0
     * | 都0，就为0，否则为1
     * ^ 相同，为0，否则为1
     */
    public void method3(){
        System.out.println(8|9&10^11);
    }

    /**
     * java的赋值运算都有返回值，返回的就是表达式右边的值，所以只有boolean 型的赋值运算表达式的结果才是 boolean型
     */
    public void method4(){
        boolean flag = false;
        if(flag = true){ //其他类型的赋值运行表达式不能写在if里，编译会报错
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    /**
     * String的相关知识
     * String为什么设计成不可变的
     * ************************
     * 不可变对象，内容不可变，如果需要复制内容，只需要复制地址即可，内存效率高；
     * 多线程安全，内容不会被其他线程改变；
     * 字符串常量池的设计，节省内存空间；
     * String内容不可变，意味着hashcode能被缓存起来，处理速度快，特别适合用来做Map的键，快过其他类型作为键；
     * ************************
     */
    public void method5(){

        String s1 = "abc";//先从常量池中拿，没有就创建一个"abc"对象，放进去

        String a = "张三";
        String b = "张";
        String c = "三";
        String d = b + c;
        System.out.println( a == d);//false，两个对象相加，会优化成StringBuilder，最后相当于new了一个对象

        String e = "张" + "三";
        System.out.println(a == e);// true，直接使用字面量，就会从常量池里处理
        System.out.println("a == e:" + a == e); //false，注意，+ 运算符优先级 高于 ==

    }

    public static void main(String[] args) {
    }
}