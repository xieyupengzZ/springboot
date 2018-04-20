package com.xieyupeng.springboot;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//Spring Boot 提倡基于Java配置，如果非要配置一个XML，可以使用@Configuration注解一个类作为导入源，一般main方法的类是一个很好的选择
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class ConfigurationClass {
}
