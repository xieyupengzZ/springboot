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

    public UserBase get(int id) {
        int i = 1/0; //抛出运行时异常，没有捕捉处理，也没有向上抛，但是调用类却接受到了
        return userBaseMapper.selectByPrimaryKey(id);
    }

}
