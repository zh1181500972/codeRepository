package com.zhanghao.dao.mapper;

import com.zhanghao.model.PmsRelation;

public interface PmsRelationMapper {
    /**
     *
     * @mbg.generated 2017-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insert(PmsRelation record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insertSelective(PmsRelation record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    PmsRelation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKeySelective(PmsRelation record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKey(PmsRelation record);
}