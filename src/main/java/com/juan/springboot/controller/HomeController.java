package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.juan.springboot.bean.Student;
import com.juan.springboot.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    @GetMapping("/unfinished")
    public Map unfinishedInfo(){
       ArrayList<Student> students = homeService.unfinishedInfo();
        Map<String,Object> map= new HashMap<>();
        map.put("total",students.size());
        map.put("rows",students);
        return map;
    }

}
