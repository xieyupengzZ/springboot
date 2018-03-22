package com.xieyupeng.springboot.controller;

import com.xieyupeng.springboot.service.UsersTokenService;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xieyupeng.springboot.model.UsersToken;


/**
 * Created by XYP on 2018/2/1.
 */
@Controller
@RequestMapping(value="token/")
public class UserTokenController {

    private static final Logger logger = LoggerFactory.getLogger(UserTokenController.class);

    @Autowired
    UsersTokenService usersTokenService;

    @ResponseBody
    @RequestMapping(value="add.d",produces = "application/json;charset=UTF-8")
    public Integer add(UsersToken usersToken){
        logger.debug(usersToken.toString());
        try {
            usersTokenService.add(usersToken);
            logger.info(usersToken.getId()+"");
        } catch (Exception e) {
            logger.error("{}",e);
            e.printStackTrace();
        }
        return usersToken.getId();
    }
}
