package com.zhanghao.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.biz.user.service.PmsUserService;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="spring/spring-context.xml")
public class DubboTest {
	//@Autowired
	//PmsUserService pmsUserService;
	
	@Test
	public void teset1(){
		//System.out.println(pmsUserService);/exam-web/src/main/resources/
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/spring-context.xml");
	}
}
