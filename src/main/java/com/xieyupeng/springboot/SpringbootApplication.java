package com.xieyupeng.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//http://blog.csdn.net/u013473691/article/details/52353923
//@SpringBootApplication 相当与三个注解，这里只解释其中一个
//@ComponentScan - 自动收集所有的Spring组件，包括 @Configuration 注解的类
@EnableTransactionManagement //启动事务
public class SpringbootApplication {

	Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

	public static void main(String[] args) {
		//TODO 直接跑
		SpringApplication.run(SpringbootApplication.class, args);
		//TODO 关闭启动时的banner图案再跑
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootApplication.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
}
