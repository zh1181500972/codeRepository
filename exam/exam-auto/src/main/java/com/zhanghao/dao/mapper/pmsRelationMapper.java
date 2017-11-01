package com.zhanghao.dao.mapper;

import com.zhanghao.model.pmsRelation;

public interface pmsRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(pmsRelation record);

    int insertSelective(pmsRelation record);

    pmsRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pmsRelation record);

    int updateByPrimaryKey(pmsRelation record);
}