package com.xieyupeng.springboot.Multithreading;

public enum XYPZZ {

    XIEYUPENG("xyp"){
        @Override
        public void info(String i){
            System.out.println("xieyupeng: "+i);
        }
    },

    ZHANGZHAO("zz"){
        @Override
        public void info(String i){
            System.out.println("zhangzhao: "+i);
        }
    };

    String des;
    XYPZZ(String s){
        des = s;
    }

    public String getdes(){
        return des;
    }

    public abstract void info(String i);
}
