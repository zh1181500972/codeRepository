package com.zhanghao.inf.user.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.biz.user.service.PmsUserService;
import com.zhanghao.common.page.PageBean;
import com.zhanghao.common.page.PageParam;
import com.zhanghao.core.utils.DateUtils;
import com.zhanghao.core.utils.Md5Utils;
import com.zhanghao.core.utils.RandomUtils;
import com.zhanghao.service.user.dao.PmsUserDao;

/**
 * @描述:用户Dubbo服务接口实现
 * @author zhanghao
 * @创建时间:2017年10月25日 下午3:18:24
 */
@Service("pmsUserService")
@Transactional
public class PmsUserServiceImpl implements PmsUserService {
	/**
	 * MD5加密随机参生盐值的长度
	 */
	private static final int SALT_LEGHT = 5;
	
	@Autowired
	private PmsUserDao pmsUserDao;

	/**
	 * 保存用户信息.
	 * 
	 * @param pmsUser
	 */
	public void create(PmsUser pmsUser) {
		String password = pmsUser.getPassword();
		if(StringUtils.isEmpty(password)){
			throw new IllegalArgumentException("用户密码不能为空");
		}
		String salt = RandomUtils.getRandomString(SALT_LEGHT);
		pmsUser.setSalt(salt);
		pmsUser.setPassword(Md5Utils.encode(password, salt));
		pmsUserDao.insert(pmsUser);
	}

	/**
	 * 根据ID获取用户信息.
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public PmsUser getById(Integer userId) {
		return pmsUserDao.selectByPrimaryKey(userId);
	}

	/**
	 * 根据登录名取得用户对象
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
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
	 * 查询并分页列出用户信息.
	 * 
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsUserDao.listPage(pageParam, paramMap);
	}

	@Override
	public void updateUserPwd(Integer userId, Integer id,String newPwd) {
		if(userId ==null || id==null || StringUtils.isEmpty(newPwd)){
			throw new IllegalArgumentException("参数异常");
		}
		PmsUser pmsUser=new PmsUser();
		pmsUser.setId(id);
		String salt = RandomUtils.getRandomString(SALT_LEGHT);
		pmsUser.setPassword(Md5Utils.encode(newPwd, salt));
		pmsUser.setSalt(salt);
		pmsUserDao.updateUserPwd(pmsUser);
	}

	@Override
	public void create(List<PmsUser> pmsUsers) {
		// TODO Auto-generated method stub
		for (PmsUser pmsUser : pmsUsers) {
			create(pmsUser);
		}
	}

}
