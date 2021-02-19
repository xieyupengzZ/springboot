package com.xieyupeng.springboot.studys.DesignMode.AdapterMode;


/**
 * 需要适配谁，就实现谁的接口
 * 这里是希望android能用iphone的数据线充电，就做了一个iphone数据线适配器
 * 传入android的手机，它本身也是使用android充电，但是外面包了一层iphone数据线适配器，外面就用iphone数据线充电了
 * 适配器的关键在于把要适配的对象，作为参数传进来了
 */
public class IphoneAdapter implements IphoneLine {

    AndroidLine androidLine;

    IphoneAdapter(AndroidLine androidLine){
        System.out.print("用苹果线");
        this.androidLine = androidLine;
    }

    @Override
    public void chargeUseIphoneLine() {
        androidLine.chargeUseAndroidLine();
    }
}
