package com.xieyupeng.springboot.DesignMode.ChainOfResponsibilityMode;

public class HandlerOne extends AbstractHandler {

    HandlerOne(AbstractHandler nextHandler, int type) {
        super(nextHandler, type);
    }

    @Override
    void process() {
        System.out.println(HandlerOne.class.getName() + " process it");
    }
}
