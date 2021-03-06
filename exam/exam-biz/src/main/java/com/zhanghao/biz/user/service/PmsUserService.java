package com.zhanghao.biz.user.service;

import java.util.List;
import java.util.Map;

import com.zhanghao.biz.entity.PmsUser;
import com.zhanghao.common.page.PageBean;
import com.zhanghao.common.page.PageParam;

/**
 * @描述:用户Dubbo服务接口
 * @author zhanghao
 * @创建时间:2017年10月25日 下午2:50:26
 */
public interface PmsUserService {
	/**
	 * 保存用户信息.
	 * 
	 * @param pmsUser
	 */
	public void create(PmsUser pmsUser);
	
	/**
	 * 批量保存用户信息.
	 * 
	 * @param pmsUser
	 */
	public void create(List<PmsUser> pmsUsers);

	/**
	 * 根据ID获取用户信息.
	 * 
	 * @param userId
	 * @return
	 */
	public PmsUser getById(Integer userId);

	/**
	 * 根据登录名取得用户对象
	 */
	public PmsUser findUserByUserNo(String userNo);

	/**
	 * 根据ID删除一个用户，同时删除与该用户关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            用户ID.
	 */
	public void deleteUserById(Integer userId);

	/**
	 * 更新用户信息.
	 * 
	 * @param user
	 */
	public void update(PmsUser user);

	/**
	 * 根据用户ID更新用户密码.
	 * 
	 * @param userId 更新人
	 * @param id    主键
	 * @param newPwd 新密码
	 */
	public void updateUserPwd(Integer userId,Integer id, String newPwd);

	/**
	 * 查询并分页列出用户信息.
	 * 
	 * @param pageParam
	 * @param paramMap
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}
