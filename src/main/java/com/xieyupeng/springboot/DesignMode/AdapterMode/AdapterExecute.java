package com.xieyupeng.springboot.DesignMode.AdapterMode;

public class AdapterExecute {

    public static void main(String[] args) {

        HuaweiPhone huaweiPhone = new HuaweiPhone();
        IphoneAdapter iphoneAdapter = new IphoneAdapter(huaweiPhone);
        iphoneAdapter.chargeUseIphoneLine();
    }

}
