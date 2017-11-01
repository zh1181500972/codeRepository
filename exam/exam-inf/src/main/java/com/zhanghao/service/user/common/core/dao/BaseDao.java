package com.zhanghao.service.user.common.core.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.zhanghao.biz.common.page.PageBean;
import com.zhanghao.biz.common.page.PageParam;

/**
 * @描述: 数据访问层基础支撑接口
 * @author zhanghao
 * @创建时间:2017年10月25日 下午3:39:03
 */
public interface BaseDao<T> {

	/***
	 * 插入不为空的数据
	 * @param record
	 * @return
	 */
	int insertSelective(T record);

	/**
	 * 更新不为空的数据
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(T record);

	/**
	 * 根据实体对象新增记录.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insert(T entity);

	/**
	 * 批量保存对象.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insert(List<T> list);

	/**
	 * 更新实体对应的记录.
	 * 
	 * @param entity
	 *            .
	 * @return
	 */
	int updateByPrimaryKey(T entity);

	/**
	 * 批量更新对象.
	 * 
	 * @param entity
	 *            .
	 * @return int .
	 */
	int update(List<T> list);

	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T selectByPrimaryKey(Integer id);

	/**
	 * 根据ID删除记录.
	 * 
	 * @param id
	 *            .
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	public List<T> listBy(Map<String, Object> paramMap);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	public T getBy(Map<String, Object> paramMap);

	public SqlSessionTemplate getSessionTemplate();

	public SqlSession getSqlSession();
}
