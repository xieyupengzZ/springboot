package com.xieyupeng.springboot.studys.DesignMode.ChainOfResponsibilityMode;

public class HandlerThr extends AbstractHandler {
    HandlerThr(AbstractHandler nextHandler, int type) {
        super(nextHandler, type);
    }

    @Override
    void process() {
        System.out.println(HandlerThr.class.getName() + " process it");
    }
}
