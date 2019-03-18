package com.xieyupeng.springboot.Others;

/**
 * 内部类相关知识
 *
 * 外部类
 * 【访问权限】：public、default
 */
public class InnerClass {

    private String name = "外部类";
    private static String name_static = "外部类静态名";

    /**
     * 成员内部类
     * 1、无条件访问外部类所有 成员属性 和 成员方法，因为编译器默认会在成员内部类的构造函数中添加一个参数（指向外部类对象的引用）
     * 2、【内部访问外部】：1.外部类.this.属性/方法；2.直接调用（属性不同名的情况下）
     * 3、【外部访问内部】：1.外部实例.new Member()
     * 4、【访问权限】：public、protected、private、包访问权限（什么都不加），就像一个成员属性一样
     */
    public class Member{

        String name = "成员内部类";

        public void show(){
            System.out.println("内部类属性：" + this.name);
            System.out.println("外部类属性：" + InnerClass.this.name);
        }
    }

    /**
     * 静态内部类
     * 1、在成员内部类的基础上，加上static，不能访问外部非 static 的属性和方法
     * 2、【访问权限】：同成员内部类
     */
    static class StaticMember{
        String name = "静态内部类";
        public void show(){
            System.out.println("内部类属性"+name);
            System.out.println("外部类属性"+InnerClass.name_static);
        }
    }

    /**
     * 局部内部类
     * 1、【访问权限】：就像方法里的一个局部变量，不能用 访问修饰符 和 static 修饰，可以用 abstract、final
     */
    public void  method1(){
       String name = "业务方法";
       class BusObject{
            String name="局部内部类";
            public void show(){
                System.out.println(name);
            }
        }
    }

    /**
     * 匿名内部类
     * 1、【访问权限】不能用 访问修饰符 和 static 修饰
     * 2、唯一没有构造器的类
     */
    public void method2(final int a){
        final int b = 1;
        new Member(){
            @Override
            public void show() {
                System.out.println(a);
                System.out.println(b);
            }
        }.show();
    }

    /**
     * 局部内部类 和 匿名内部类 都处于一个方法当中
     * 【问题】方法调用结束后，生命周期结束（局部变量和形参也结束），但是内部类的生命周期未结束，仍然需要访问方法中的变量；
     * 【方案】复制：局部变量编译期间可确定值，就创建一个拷贝；如果不能确定，通过构造器传参的方式来对拷贝初始化复制；
     *        思想：保证访问的不是那个生命周期已结束的局部变量，是它的拷贝；
     * 【问题】数据不一致：限制传参必须是final变量
     * @param args
     */

    /**
     * 创建内部类实例
     * abstract 类 不能 使用 static 和 final
     * @param args
     */
    public static void main(String[] args) {
        //成员内部类(必须先创建一个外部类实例)
        Member member = new InnerClass().new Member();
        //静态内部类(不需要先创建一个外部类实例)
        StaticMember staticMember = new StaticMember();

    }

}
