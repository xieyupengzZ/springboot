package com.xieyupeng.springboot.DesignMode.StartegyMode;

public class StrategyExecute {
    public static void main(String[] args) {
        AbstractTrafficToolsForWork tool = new Bus();
        Work work = new Work(tool);
        work.goToWork();
    }
}
