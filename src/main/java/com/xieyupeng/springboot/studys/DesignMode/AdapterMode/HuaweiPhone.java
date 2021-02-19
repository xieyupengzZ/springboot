package com.xieyupeng.springboot.studys.DesignMode.AdapterMode;

public class HuaweiPhone implements AndroidLine {
    @Override
    public void chargeUseAndroidLine() {
        System.out.println("给华为手机充电");
    }
}
