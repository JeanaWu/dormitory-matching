package com.juan.springboot.service;

import com.juan.springboot.mapper.HabitsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 根据session获取id然后将网页中的数据插入数据库
 * 学生习惯的存储
 * 需要完善，储存成功时候的提示，以及账号重复的时候的提醒
 */
@Service
public class SurveyService {
    @Autowired
    HabitsMapper habitsMapper;

    public String getHabitsId(HttpSession session){
       int id= (int) session.getAttribute("id");
        return habitsMapper.getIdById(id);
    }

    public void addsurvey( HttpSession session,Integer slpTime, Integer gupTime, Integer slpNoisy,
                          Integer slpHabits, Integer clean, Integer games, Integer atmos, Integer characters
                          ){
        Integer id= (Integer) session.getAttribute("id");
        habitsMapper.addHabits(id,slpTime,gupTime,slpNoisy,slpHabits,clean,games,atmos,characters);
    }
}
