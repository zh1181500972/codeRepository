package com.zhanghao.biz.entity;

import java.util.Date;

import com.zhanghao.common.entity.BaseEntity;

public class PmsRole extends BaseEntity {

	/**
	 * 序号
	 */
	private Integer num;

	/**
	 * 父角色id
	 */
	private Integer pid;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 部门名称
	 */
	private Integer deptid;

	/**
	 * 提示
	 */
	private String tips;

	/**
	 * 序号
	 * 
	 * @return num 序号
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * 序号
	 * 
	 * @param num
	 *            序号
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * 父角色id
	 * 
	 * @return pid 父角色id
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 父角色id
	 * 
	 * @param pid
	 *            父角色id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 角色名称
	 * 
	 * @return name 角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 角色名称
	 * 
	 * @param name
	 *            角色名称
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 部门名称
	 * 
	 * @return deptid 部门名称
	 */
	public Integer getDeptid() {
		return deptid;
	}

	/**
	 * 部门名称
	 * 
	 * @param deptid
	 *            部门名称
	 */
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	/**
	 * 提示
	 * 
	 * @return tips 提示
	 */
	public String getTips() {
		return tips;
	}

	/**
	 * 提示
	 * 
	 * @param tips
	 *            提示
	 */
	public void setTips(String tips) {
		this.tips = tips == null ? null : tips.trim();
	}

	private PmsUser pmsUser;

	public PmsUser getPmsUser() {
		return pmsUser;
	}

	public void setPmsUser(PmsUser pmsUser) {
		this.pmsUser = pmsUser;
	}
}