package com.xieyupeng.springboot.service;

import com.xieyupeng.springboot.mapper.UserBaseMapper;
import com.xieyupeng.springboot.model.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by XYP on 2018/1/31.
 */
@Service
public class UserBaseService {

    @Autowired
    UserBaseMapper userBaseMapper;

    public UserBase get(int id){
        return userBaseMapper.selectByPrimaryKey(id);
    }

}
