package com.xieyupeng.springboot.studys.DesignMode.StartegyMode;

public class Work {

    AbstractTrafficToolsForWork tool;

    Work(AbstractTrafficToolsForWork toolsForWork){
        tool = toolsForWork;
    }

    public void goToWork(){
        tool.use();
    }

}
