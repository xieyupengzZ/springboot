package com.xieyupeng.springboot.DesignMode.FactoryMode;

//三星手机工厂，同时创建对象时，使用双加锁单例，这样他们拿到的都是同一个手机，哈哈
public class SamsungFactory implements AbstractPhoneFactory {

    private static Samsung samsung = null;

    @Override
    public  Phone createPhone() {
        if(samsung==null){
            System.out.println(Thread.currentThread().getName() + "发现还没有产品");
            synchronized (SamsungFactory.class){
                if(samsung==null){
                    System.out.println("我看看是谁这么幸运，oh，原来是你这个小调皮："+Thread.currentThread().getName());
                    samsung = new Samsung();
                }else {
                    System.out.println("oh，你来晚了 "+Thread.currentThread().getName());
                }
            }
        }
        return samsung;
    }
}
