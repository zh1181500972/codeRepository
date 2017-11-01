package com.zhanghao.inf.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanghao.biz.common.page.PageBean;
import com.zhanghao.biz.common.page.PageParam;
import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.biz.user.service.PmsUserService;
import com.zhanghao.service.user.dao.PmsUserDao;

/**
 * @描述:用户Dubbo服务接口实现
 * @author zhanghao
 * @创建时间:2017年10月25日 下午3:18:24
 */
@Service("pmsUserService")
public class PmsUserServiceImpl implements PmsUserService {
	@Autowired
	private PmsUserDao pmsUserDao;

	/**
	 * 保存用户信息.
	 * 
	 * @param pmsUser
	 */
	public void create(PmsUser pmsUser) {
		pmsUserDao.insert(pmsUser);
	}

	/**
	 * 根据ID获取用户信息.
	 * 
	 * @param userId
	 * @return
	 */
	public PmsUser getById(Integer userId) {
		return pmsUserDao.selectByPrimaryKey(userId);
	}

	/**
	 * 根据登录名取得用户对象
	 */
	public PmsUser findUserByUserNo(String userNo) {
		return pmsUserDao.findByUserNo(userNo);
	}

	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserById(Integer userId) {
		pmsUserDao.deleteByPrimaryKey(userId);
	}

	/**
	 * 更新用户信息.
	 * 
	 * @param user
	 */
	public void update(PmsUser user) {
		pmsUserDao.updateByPrimaryKey(user);
	}

	/**
	 * 根据用户ID更新用户密码.
	 * 
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd, boolean isTrue) {
		pmsUserDao.updateUserPwd(userId, newPwd, isTrue);
	}

	/**
	 * 查询并分页列出用户信息.
	 * 
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsUserDao.listPage(pageParam, paramMap);
	}

	@Override
	public void updateUserPwd(Integer userId, String newPwd, boolean isTrue) {
		// TODO Auto-generated method stub
		
	}

}
