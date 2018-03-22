package com.xieyupeng.springboot.service;

import com.xieyupeng.springboot.mapper.UsersTokenMapper;
import com.xieyupeng.springboot.model.UsersToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by XYP on 2018/2/1.
 */
@Service
public class UsersTokenService {

    @Autowired
    UsersTokenMapper mapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=120,rollbackFor=Exception.class)
    public int add(UsersToken usersToken) {
        return mapper.insert(usersToken);
//        throw new RuntimeException();
    }

}
