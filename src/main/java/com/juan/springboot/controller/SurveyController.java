package com.juan.springboot.controller;

import com.juan.springboot.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 学生跳转到调查问卷页面
     */
    @GetMapping(value="/survey")
    public String toSurvey(){

        return "stu/survey";
    }


    /**
     * 学生调查问卷信息添加
     */
    @PostMapping("/survey")
    public String addHabits(@RequestParam("slpTime") Integer slpTime, @RequestParam("gupTime") Integer gupTime,
                            @RequestParam("slpNoisy") Integer slpNoisy, @RequestParam("slpHabits") Integer slpHabits,
                            @RequestParam("clean") Integer clean, @RequestParam("games") Integer games,
                            @RequestParam("atmos") Integer atoms, @RequestParam("characters") Integer characters, HttpSession session,
                            Map<String, Object> map) {
        String habitsId = surveyService.getHabitsId(session);
        try {
            surveyService.addsurvey(session, slpTime, gupTime, slpNoisy, slpHabits, clean, games, atoms, characters);
        } catch (Exception e) {
            if (habitsId != null) {
                map.put("msg", "您已经填写过调查问卷，请勿重复填写");
                return "/stu/survey";
            }
        }
        return "Dashboard";
    }
}
