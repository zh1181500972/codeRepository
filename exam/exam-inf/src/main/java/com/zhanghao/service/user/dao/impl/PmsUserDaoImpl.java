package com.zhanghao.service.user.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.common.dao.BaseDaoImpl;
import com.zhanghao.service.user.dao.PmsUserDao;


/**
 * @描述:用户表数据访问层接口实现类.
 * @author zhanghao
 * @创建时间:2017年10月25日 下午3:42:31
 */
@Repository("pmsUserDao")
public class PmsUserDaoImpl extends BaseDaoImpl<PmsUser> implements PmsUserDao {

	/**
	 * 根据用户登录名获取用户信息.
	 * 
	 * @param loginName
	 *            .
	 * @return user .
	 */

	public PmsUser findByUserNo(String userNo) {
		return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
	}

	@Override
	public void updateUserPwd(PmsUser pmsUser) {
		// TODO Auto-generated method stub
		super.getSqlSession().update(getStatement("updateUserPwd"),pmsUser);
	}

}
