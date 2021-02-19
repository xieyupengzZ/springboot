package com.xieyupeng.springboot.studys.Others;

import java.util.Collections;

/**
 * 子类和父类
 * 父类静态成员->父类静态代码块->子类静态成员->子类静态代码块
 * ->父类成员属性->父类代码块->父类构造函数->子类成员属性->子类代码块->子类构造函数
 */
public class ParentAndSun {

    String name = "子类和父类";
    Integer order = 1;

    /**
     * this的作用
     * 1、this 代表自身类的对象，不能放在static静态方法中
     * 2、this 调用 成员变量、成员方法
     * 3、this 在构造函数中，另一个构造函数
     * 4、this 和 super 不能放在同一构造函数中
     * @param order
     */
    public ParentAndSun(Integer order){
        this.order = order;
        System.out.println(show());
    }
    public ParentAndSun(){
        this(1);
        this.name = this.createName();
    }
    public String createName(){
        return "父子测试类";
    }

    /**
     * return 表达式【执行完】之前，会先执行 finally，不是【执行】之前
     * 执行 finally 之前，try 中 return 表达式的结果会暂时保存起来，不会被改变
     * 等 finally 执行完毕后，再回来 拿结果返回
     * @return
     */
    public Integer show(){
        try{
            return this.order;
        }finally {
            this.order = 2;
        }
    }

    /**
     * 父类
     */
    public class Parent{

        String name = "父类";
        public Parent(String name){
            this.name = name;
            method();
        }

        public void method(){
            System.out.println("父类的方法");
        }
    }

    /**
     * 子类
     * 1、构造函数不能被继承，只能被显示或隐示地调用
     * 2、子类构造函数第一行，隐示地调用super()；如果父类没有无参的构造函数，必须显示调用有参构造函数
     * 3、子类可直接调用父类的方法（public和protected），重名的可以用super引用
     */
    public class Sun extends Parent{

        String name = "子类";
        public Sun(){
            super("");
        }
        public Sun(String name) {
            super(name); //必须放在第一行；不写的话，隐示地调用super()；
            this.name = name;
        }

        public void method(){
            System.out.println("子类的方法");
        }

    }

    /**
     * 父类方法被子类重写后，子类实例化过程中，如果调用到了该重写的方法（比如在父类的构造函数中），那么调用的就是子类的方法
     * 如果是用 this 调用重写的方法 ，调用仍然是子类的，因为是子类实例化
     * 除非明确使用 super，调用的才是父类的方法
     */
    public static void main(String[] args){
        Parent parent = new ParentAndSun().new Parent("父类");
        Parent sun1 = new ParentAndSun().new Sun("子类1");
    }

}
