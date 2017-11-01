package com.zhanghao.dao.mapper;

import com.zhanghao.model.PmsRole;

public interface PmsRoleMapper {
    /**
     *
     * @mbg.generated 2017-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insert(PmsRole record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insertSelective(PmsRole record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    PmsRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKeySelective(PmsRole record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKey(PmsRole record);
}