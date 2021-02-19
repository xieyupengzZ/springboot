package com.xieyupeng.springboot.studys.DesignMode.ChainOfResponsibilityMode;

public class Execute {

    static AbstractHandler createChain(){
        AbstractHandler handler3 = new HandlerThr(null,3);
        AbstractHandler handler2 = new HandlerTwo(handler3,2);
        AbstractHandler handler1 = new HandlerOne(handler2,1);
        return handler1;
    }

    public static void main(String[] args) {
        AbstractHandler handler = Execute.createChain();
        handler.handle(1);
        handler.handle(2);
        handler.handle(3);
        handler.handle(0);
    }

}
