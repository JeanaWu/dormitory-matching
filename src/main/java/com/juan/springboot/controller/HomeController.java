package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.juan.springboot.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 管理员首页的信息显示
 */
@Controller
public class HomeController {
    @Autowired
    HomeService homeService;

    @ResponseBody
    @GetMapping("/homeInfo")
    public Object homeInfo(){
        Object o = JSONObject.toJSON(homeService.homeInfo());
        return o;
    }
}
