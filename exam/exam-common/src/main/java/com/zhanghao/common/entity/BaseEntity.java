package com.zhanghao.common.entity;

import java.util.Date;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import io.swagger.annotations.ApiParam;

public class BaseEntity {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 创建时间
	 */
	private Date createtime;

	/**
	 * 保留字段
	 */
	private Integer version;

	/**
	 * 修改时间
	 */
	private Date updatetime;

	/**
	 * 修改人
	 */
	private Integer updateuser;

	/**
	 * 主键id
	 * 
	 * @param id
	 *            主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 主键id
	 * 
	 * @return id 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 创建时间
	 * 
	 * @return createtime 创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createtime
	 *            创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 保留字段
	 * 
	 * @return version 保留字段
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 保留字段
	 * 
	 * @param version
	 *            保留字段
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 修改时间
	 * 
	 * @return updatetime 修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * 修改时间
	 * 
	 * @param updatetime
	 *            修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * 修改人
	 * 
	 * @return updateuser 修改人
	 */
	public Integer getUpdateuser() {
		return updateuser;
	}

	/**
	 * 修改人
	 * 
	 * @param updateuser
	 *            修改人
	 */
	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}
}
