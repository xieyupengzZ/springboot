package com.xieyupeng.springboot.DesignMode.StartegyMode;

public class Work {

    AbstractTrafficToolsForWork tool;

    Work(AbstractTrafficToolsForWork toolsForWork){
        tool = toolsForWork;
    }

    public void goToWork(){
        tool.use();
    }

}
