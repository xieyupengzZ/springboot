package com.xieyupeng.springboot.studys.DesignMode.ChainOfResponsibilityMode;

public class HandlerTwo extends AbstractHandler {
    HandlerTwo(AbstractHandler nextHandler, int type) {
        super(nextHandler, type);
    }

    @Override
    void process() {
        System.out.println(HandlerTwo.class.getName() + " process it");
    }
}
