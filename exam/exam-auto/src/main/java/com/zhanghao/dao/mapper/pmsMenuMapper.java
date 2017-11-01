package com.zhanghao.dao.mapper;

import com.zhanghao.model.pmsMenu;

public interface pmsMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(pmsMenu record);

    int insertSelective(pmsMenu record);

    pmsMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pmsMenu record);

    int updateByPrimaryKey(pmsMenu record);
}