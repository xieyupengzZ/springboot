package com.xieyupeng.springboot.studys.DesignMode.FactoryMode;

public class OppoFactory implements AbstractPhoneFactory {
    @Override
    public Phone createPhone() {
        return new Oppo();
    }
}
