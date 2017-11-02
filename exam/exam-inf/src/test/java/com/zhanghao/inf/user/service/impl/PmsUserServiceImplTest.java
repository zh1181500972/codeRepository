package com.zhanghao.inf.user.service.impl;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.biz.user.service.PmsUserService;
import com.zhanghao.common.page.PageBean;
import com.zhanghao.common.page.PageParam;
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
		List<PmsUser> list=new ArrayList<PmsUser>();
		for(int i=0;i<=100;i++){
			PmsUser pmsUser=new PmsUser();
			pmsUser.setAccount("zengshaowebg");
			pmsUser.setAvatar("/head/zengshaowebg.png");
			pmsUser.setBirthday(DateUtils.parse("1996-12-28"));
			pmsUser.setName("曾少文1");
			pmsUser.setPassword("112233");
			pmsUser.setUpdateuser(1);
			pmsUser.setStatus(1);
			pmsUser.setPhone(RandomUtils.randomPhone());
			pmsUser.setEmail(RandomUtils.randomEmail());
			pmsUserService.create(pmsUser);
			list.add(pmsUser);
		}
		pmsUserService.create(list);
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-start));
	}

	@Test
	public void testGetByIdInteger() {
		PmsUser byId = pmsUserService.getById(1);
		Assert.assertNotNull(byId);
	}

	@Test
	public void testFindUserByUserNo() {
		PmsUser pmsUser = pmsUserService.findUserByUserNo("zhanghao");
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
