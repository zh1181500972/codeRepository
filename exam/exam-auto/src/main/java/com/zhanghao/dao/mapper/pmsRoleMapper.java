package com.zhanghao.dao.mapper;

import com.zhanghao.model.pmsRole;

public interface pmsRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(pmsRole record);

    int insertSelective(pmsRole record);

    pmsRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pmsRole record);

    int updateByPrimaryKey(pmsRole record);
}