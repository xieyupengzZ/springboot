package com.xieyupeng.springboot.DesignMode.TemplateMethodMode;

public class RealTemplateFir extends AbstractTemplate {
    @Override
    public void operation1() {
        System.out.println(this.getClass().getName() + "operation1");
    }

    @Override
    public void operation2() {
        System.out.println(this.getClass().getName() + "operation2");
    }
}
