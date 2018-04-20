package com.xieyupeng.springboot.DesignMode.TemplateMethodMode;

import java.util.Calendar;

public class TemplateMethodExecute {

    public static void main(String[] args) {
        AbstractTemplate one = new RealTemplateFir();
        one.execute();
        System.out.println();
        AbstractTemplate two = new RealTemplateSec();
        two.execute();
    }


}
