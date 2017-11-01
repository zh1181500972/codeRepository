package com.zhanghao.inf.user.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.biz.user.service.PmsUserService;
import com.zhanghao.core.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-context.xml")
public class PmsUserServiceImplTest {
	@Autowired
	PmsUserService pmsUserService;

	@Test
	public void testCreate() {
		PmsUser pmsUser=new PmsUser();
		pmsUser.setAccount("zhanghao");
		pmsUser.setAvatar("/head/zhanghao.png");
		pmsUser.setBirthday(DateUtils.parse("1996-12-28"));
		pmsUser.setName("张浩");
		pmsUser.setPassword("123456");
		pmsUserService.create(pmsUser);
	}

	@Test
	public void testGetByIdInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByUserNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserByIdInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserPwd() {
		fail("Not yet implemented");
	}

	@Test
	public void testListPage() {
		fail("Not yet implemented");
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
