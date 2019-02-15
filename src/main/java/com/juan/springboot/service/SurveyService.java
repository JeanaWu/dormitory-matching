package com.juan.springboot.service;

import com.juan.springboot.mapper.HabitsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Service
public class SurveyService {
    @Autowired
    HabitsMapper habitsMapper;


    /**
     * 学生问卷填写信息保存
     */

    public String addsurvey(HttpSession session, Integer slpTime, Integer gupTime, Integer slpNoisy,
                            Integer slpHabits, Integer clean, Integer games, Integer atmos, Integer characters,Map<String, Object> map) {
        Integer id = (Integer) session.getAttribute("id");

        try {
            habitsMapper.addHabits(id, slpTime, gupTime, slpNoisy, slpHabits, clean, games, atmos, characters);
        } catch (Exception e) {
            if (habitsMapper.getIdById(id) != null) {
                map.put("msg", "您已经填写过调查问卷，请勿重复填写");
                return "/stu/survey";
            }
        }
        map.put("msg","问卷填写完成");
        return "/stu/Dashboard";
    }



}
