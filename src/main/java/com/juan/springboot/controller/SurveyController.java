package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.servlet.http.HttpSession;
import java.util.Map;
/**
 * 跳转到调查问卷页面
 * 通过session中存储的id属性获得当前学生的id，去stu_habits表中查找是否存在调查问卷信息
 * 若存在则提示已经填写过问卷
 * 若不存在则将前端获取的信息加入表中
 */
@Controller
public class SurveyController {
    @Autowired
    SurveyService surveyService;
    /**
     * 学生调查问卷信息添加
     */
    @ResponseBody
    @PostMapping("/addSurvey")
    public Object addHabits(@RequestBody String requestString) {
       StuHabits stuHabits=new Gson().fromJson(requestString, new TypeToken<StuHabits>(){}.getType());
       Integer id=stuHabits.getId();
       Integer slpTime=stuHabits.getSlpTime();
       Integer gupTime=stuHabits.getGupTime();
       Integer slpNoisy=stuHabits.getSlpNoisy();
       Integer slpHabits=stuHabits.getSlpHabits();
       Integer clean=stuHabits.getClean();
       Integer games=stuHabits.getGames();
       Integer atoms=stuHabits.getAtmos();
       Integer characters=stuHabits.getCharacters();

       Object o = JSONObject.toJSON(surveyService.addSurvey(id,slpTime, gupTime, slpNoisy, slpHabits, clean, games, atoms, characters));
        System.out.println(o);
        return o;

    }
}
