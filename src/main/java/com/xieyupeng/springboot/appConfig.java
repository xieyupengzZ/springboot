package com.xieyupeng.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by XYP on 2018/1/31.
 */
@Component
//@ConfigurationProperties(prefix="appconfig",locations = "classpath:appConfig.properties")
/**
 * 最新版本的springboot的@ConfigurationProperties去掉了locations属性，改用@PropertySource指定其他的配置文
 * @PropertySource 不能作用在方法上，要写在类上
 */
@ConfigurationProperties(prefix="appconfig")
@PropertySource("classpath:appConfig.properties")
public class appConfig {

    private String sqUrl;
    private String myUrl;
    private String apiUrl;
    private String dataUrl;
    private String ptUrl;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSqUrl() {
        return sqUrl;
    }

    public void setSqUrl(String sqUrl) {
        this.sqUrl = sqUrl;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getPtUrl() {
        return ptUrl;
    }

    public void setPtUrl(String ptUrl) {
        this.ptUrl = ptUrl;
    }
}
