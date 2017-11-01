package com.zhanghao.dao.mapper;

import com.zhanghao.model.pmsUser;

public interface pmsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(pmsUser record);

    int insertSelective(pmsUser record);

    pmsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pmsUser record);

    int updateByPrimaryKey(pmsUser record);
}