package com.xieyupeng.springboot.DesignMode.FactoryMode;

public class OppoFactory implements AbstractPhoneFactory {
    @Override
    public Phone createPhone() {
        return new Oppo();
    }
}
