package com.xieyupeng.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//		MOCK —提供一个Mock的Servlet环境，内置的Servlet容器并没有真实的启动，主要搭配使用@AutoConfigureMockMvc
//		RANDOM_PORT — 提供一个真实的Servlet环境，也就是说会启动内置容器，然后使用的是随机端口
//		DEFINED_PORT — 这个配置也是提供一个真实的Servlet环境，使用的默认的端口，如果没有配置就是8080
//		NONE — 这是个神奇的配置，跟Mock一样也不提供真实的Servlet环境。
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//使用随机端口
public class SpringbootApplicationTests {


	@Autowired
	private TestRestTemplate testRestTemplate;//你可以获取一个普通的或发送基本HTTP认证（使用用户名和密码）的模板。其实可以直接使用httpclient

	@Test
	public void get() {
//		Runtime.getRuntime().totalMemory();
		//byte,short,char<int<long<float<double,低向高自动转换
//		int x = 4;
//		System.out.println("values is " + ((x>4)?9:99.9));//最后一个数字类型自动向第二个转换
//		int p =1,q=2,z=3;
//		System.out.println(q+=z--/++p);//z--是先使用，再减1，所以此处是3/2，但是这里都是int型，所以结果是1，而非1.5
//		System.out.println(Math.random()); //0<= <1 double
		System.out.println(8|9&10^11);
	}

}
