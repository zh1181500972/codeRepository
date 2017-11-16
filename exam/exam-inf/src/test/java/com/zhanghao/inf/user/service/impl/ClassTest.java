package com.zhanghao.inf.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.zhanghao.biz.entity.PmsRole;
import com.zhanghao.biz.entity.PmsUser;

public class ClassTest {
	@Test
	public void testGetByIdInteger() {
//		 PmsUser byId = pmsUserService.getById(1);
//		 Assert.assertNotNull(byId);
		PmsRole role = new PmsRole();
		role.setId(1);
		role.setCreatetime(new Date());
		role.setName("张浩");
		role.setTips("1,2,3");
		role.setNum(1);
		PmsUser pmsUser=new PmsUser();
		pmsUser.setName("aa");
		pmsUser.setPassword("123456");
		pmsUser.setPmsRole(role);
		role.setPmsUser(pmsUser);
		System.out.println(role);
		//long [] iqwe= {1,2,3,4};
		List<Integer> iqwe=new ArrayList<Integer>();
		System.out.println(iqwe.getClass().getName());
		
	}
}
