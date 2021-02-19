package com.xieyupeng.springboot.studys.Others;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MybatisSourceCode {

    void getJdbcProperties(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("mybatis.properties"));
            Properties properties = new Properties();
            properties.load(bufferedReader);
            properties.getProperty("spring.datasource.url");//通过key来获取value
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void SpringMybatis(){
    }
}
