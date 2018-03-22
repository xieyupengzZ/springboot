package com.xieyupeng.springboot.controller;

import com.xieyupeng.springboot.appConfig;
import com.xieyupeng.springboot.model.UserBase;
import com.xieyupeng.springboot.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XYP on 2018/1/31.
 */
@Controller
@RequestMapping(value="/user")
public class UserBaseController {

    @Autowired
    UserBaseService userBaseService;
    @Autowired
    appConfig appConfig;

    @ResponseBody
    @RequestMapping(value="/get.json",produces = {"application/json;charset=UTF-8"})
    public UserBase get(@RequestParam(required = false) Integer userId){
        if(userId==null){
            userId = appConfig.getUserId();
        }
        System.out.println(appConfig.getApiUrl());
        System.out.println(appConfig.getDataUrl());
        System.out.println(appConfig.getDataUrl());
        System.out.println(appConfig.getPtUrl());
        System.out.println(appConfig.getSqUrl());
        return userBaseService.get(userId);

    }

}
