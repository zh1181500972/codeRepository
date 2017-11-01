package com.zhanghao.dao.mapper;

import com.zhanghao.model.PmsUser;

public interface PmsUserMapper {
    /**
     *
     * @mbg.generated 2017-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insert(PmsUser record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insertSelective(PmsUser record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    PmsUser selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKeySelective(PmsUser record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKey(PmsUser record);
}