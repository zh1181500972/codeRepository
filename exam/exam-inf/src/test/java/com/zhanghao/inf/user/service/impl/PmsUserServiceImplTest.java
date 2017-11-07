package com.zhanghao.inf.user.service.impl;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.biz.user.service.PmsUserService;
import com.zhanghao.common.page.PageBean;
import com.zhanghao.common.page.PageParam;
import com.zhanghao.core.aop.LogAopTest;
import com.zhanghao.core.utils.ChineseUtils;
import com.zhanghao.core.utils.DateUtils;
import com.zhanghao.core.utils.RandomUtils;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-context.xml")
public class PmsUserServiceImplTest {
	@Autowired
	PmsUserService pmsUserService;

	@Test
	public void testCreate() throws Exception {
		PmsUser pmsUser=new PmsUser();
		pmsUser.setAccount("zengshaowebg");
		pmsUser.setAvatar("/head/zengshaowebg.png");
		pmsUser.setBirthday(DateUtils.parse("1996-12-28"));
		pmsUser.setName("曾少文1");
		pmsUser.setPassword("112233");
		pmsUser.setUpdateuser(1);
		pmsUserService.create(pmsUser);
		
	}
	
	@Test
	public void testCreateList() throws Exception {
		long start = System.currentTimeMillis();
		BlockingQueue<Runnable> workQueue=new ArrayBlockingQueue<>(150);
		RejectedExecutionHandler a=new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				try {
					executor.getQueue().put(r);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		ThreadPoolExecutor threadPool =new ThreadPoolExecutor(20, 25, 0, TimeUnit.SECONDS, workQueue,a);
		final CountDownLatch count=new CountDownLatch(600);
		for(int i=0;i<600;i++){
			threadPool.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName()+"开始执行任务");
					long s = System.currentTimeMillis();
					List<PmsUser> list=new ArrayList<PmsUser>();
					for(int i=0;i<=10000;i++){
						PmsUser pmsUser=new PmsUser();
						String chineName = RandomUtils.randomChineName();
						String pingYin = ChineseUtils.getPingYin(chineName);
						pmsUser.setAccount(pingYin);
						pmsUser.setAvatar("/head/"+pingYin+".png");
						pmsUser.setBirthday(DateUtils.parse(RandomUtils.randomDate(1960, 2013)));
						pmsUser.setName(chineName);
						pmsUser.setPassword("123456");
						pmsUser.setUpdateuser(1);
						pmsUser.setSex(RandomUtils.getRangeNum(1,2));
						pmsUser.setStatus(1);
						pmsUser.setPhone(RandomUtils.randomPhone());
						pmsUser.setEmail(RandomUtils.randomEmail());
						list.add(pmsUser);
					}
					pmsUserService.create(list);
					count.countDown();;
					long e = System.currentTimeMillis();
					System.out.println(Thread.currentThread().getName()+"开始执行任务完成:"+(e-s));
				}
			});
		}
		long end = System.currentTimeMillis();
		System.out.println("等待中.."+threadPool.getActiveCount());
		count.await();
		System.out.println("task finished");
		threadPool.shutdown();
		System.out.println("耗时："+(end-start));
	}

	@Test
	public void testGetByIdInteger() {
		PmsUser byId = pmsUserService.getById(1);
		Assert.assertNotNull(byId);
	}

	@Test
	public void testFindUserByUserNo() {
		PmsUser pmsUser = pmsUserService.findUserByUserNo("wangwu");
		Assert.assertNotNull(pmsUser);
	}
	@Test
	public void testDeleteUserByIdInteger() {
		pmsUserService.deleteUserById(45);
	}

	@Test
	public void testUpdate() {
		PmsUser pmsUser=new PmsUser();
		pmsUser.setId(46);
		pmsUser.setAccount("wangwu");
		pmsUser.setAvatar("/head/wangwu.png");
		pmsUser.setBirthday(DateUtils.parse("1996-12-28"));
		pmsUser.setName("王五3");
		pmsUser.setPassword("1234526");
		pmsUserService.update(pmsUser);
	}

	@Test
	public void testUpdateUserPwd() {
		pmsUserService.updateUserPwd(1,46, "123456");
	}

	@Test
	public void testListPage() {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		PageParam pageParam=new PageParam(1, 10);
		PageBean<PmsUser> listPage = pmsUserService.listPage(pageParam, paramMap);
		List<PmsUser> recordList = listPage.getRecordList();
		//Assert.assertEquals(recordList.size(), 5);
		System.out.println(recordList.size());
	}

	@Test
	public void testGetByIdLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserByIdLong() {
		fail("Not yet implemented");
	}

	public PmsUserService getPmsUserService() {
		return pmsUserService;
	}

	public void setPmsUserService(PmsUserService pmsUserService) {
		this.pmsUserService = pmsUserService;
	}

}
