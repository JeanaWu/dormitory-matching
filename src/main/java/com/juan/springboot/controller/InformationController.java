package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.juan.springboot.bean.Information;

import com.juan.springboot.service.InformationService;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class InformationController {
    @Autowired
    InformationService informationService;

    //增加公告
    @ResponseBody
    @RequestMapping(value = "/Information", method = RequestMethod.POST)
    public Object addInformation(@RequestBody String requestString){
        Gson gson = new GsonBuilder().setDateFormat("yyyy/M/dd HH:mm:ss").create();
        Information information=gson.fromJson(requestString, new TypeToken<Information>(){}.getType());
        String content=information.getContent();
        Date date=information.getDate();
        System.out.println(content+""+date);
        Object o = JSONObject.toJSON(informationService.addInformation(content,date));
        return o;
    }

    //显示所有公告
    @ResponseBody
    @GetMapping("/allInformation")
    public ArrayList<Information> allInformation() {
        return informationService.getAll();
    }

    //删除公告
    @ResponseBody
    @PostMapping("/deleteInformation")
    public Object deleteInformation(@RequestBody String requestString){
        Information information=new Gson().fromJson(requestString, new TypeToken<Information>(){}.getType());
        Integer num=information.getNum();
        Object o= JSONObject.toJSON(informationService.deleteInformation(num));
        return o;
    }
}
