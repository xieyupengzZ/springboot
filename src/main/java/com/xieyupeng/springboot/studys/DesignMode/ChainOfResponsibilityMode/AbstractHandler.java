package com.xieyupeng.springboot.studys.DesignMode.ChainOfResponsibilityMode;


/**
 * 抽象处理类定义了方法来判断谁处理，处理的条件需要处理问题时作为参数传入。
 */
public abstract class AbstractHandler {

    protected int type;

    AbstractHandler nextHandler;

    AbstractHandler(AbstractHandler nextHandler,int type){
        this.nextHandler = nextHandler;
        this.type = type;
    }

    final void handle(int type){
        if(this.type == type){
            this.process();
        }else if(nextHandler!=null){
            nextHandler.handle(type);
        }else
            System.out.println("no handler for it");
    }

    abstract void process();
}
