package com.xieyupeng.springboot.mapper;


import com.xieyupeng.springboot.model.UserBase;

public interface UserBaseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}