package com.xieyupeng.springboot.DesignMode.FactoryMode;

public class IPhoneFactory implements AbstractPhoneFactory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
