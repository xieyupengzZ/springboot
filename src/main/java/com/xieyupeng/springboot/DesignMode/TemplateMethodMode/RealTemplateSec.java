package com.xieyupeng.springboot.DesignMode.TemplateMethodMode;

import java.util.Calendar;

public class RealTemplateSec extends AbstractTemplate {
    @Override
    public void operation1() {
        System.out.println(this.getClass().getName() + "operation1");
    }

    @Override
    public void operation2() {
        System.out.println(this.getClass().getName() + "operation2");
    }

    /**
     * 子类可以选择是否实现
     * @return
     */
    @Override
    public boolean choose(){
        if(Calendar.getInstance().get(Calendar.HOUR)<12){ //只有在上午才返回true
            return true;
        }else
            return false;
    }
}
