package com.xieyupeng.springboot.studys.DesignMode.FactoryMode;

public class IPhoneFactory implements AbstractPhoneFactory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
