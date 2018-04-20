package com.xieyupeng.springboot.DesignMode.FactoryMode;

public class ProducePhone {

    public static void main(String[] args) {

//        AbstractPhoneFactory factory1 = new IPhoneFactory();
//        Phone phone1 = factory1.createPhone();
//        phone1.info();
//        AbstractPhoneFactory factory2 = new SamsungFactory();
//        Phone phone2 = factory2.createPhone();
//        phone2.info();
//        AbstractPhoneFactory factory3 = new OppoFactory();
//        Phone phone3 = factory3.createPhone();
//        phone3.info();

        for (int i = 0 ; i < 10 ; i ++){
            new Thread(()->{
                    AbstractPhoneFactory factory = new SamsungFactory();
                    factory.createPhone();
                }
            ).start();
        }

    }
}
