package com.zhanghao.dao.mapper;

import com.zhanghao.model.PmsMenu;

public interface PmsMenuMapper {
    /**
     *
     * @mbg.generated 2017-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insert(PmsMenu record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int insertSelective(PmsMenu record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    PmsMenu selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKeySelective(PmsMenu record);

    /**
     *
     * @mbg.generated 2017-11-01
     */
    int updateByPrimaryKey(PmsMenu record);
}