package com.xieyupeng.springboot.DesignMode.TemplateMethodMode;

public abstract class AbstractTemplate {

    public final void execute(){
        operation1();
        operation2();
        /**
         * 钩子方法控制模板的地方
         */
        if(choose()){
            operation3();
        }
    }

    public abstract void operation1();

    public abstract void operation2();

    /**
     * 钩子方法，给子类提供了一个可以控制模板中的算法的机会
     */
    public boolean choose(){
        return false;
    }

    private void operation3(){
        System.out.println("这个算法只有高层能执行，但是子类可以选择控制（通过覆盖钩子方法），高层默认不返回，返回了就表示子类控制了");
    }

}
