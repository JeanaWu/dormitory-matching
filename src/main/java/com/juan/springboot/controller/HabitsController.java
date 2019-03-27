package com.juan.springboot.controller;

import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.service.HabitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HabitsController {
    @Autowired
    HabitsService habitsService;

    /**
     * 管理员查询学生的问卷填写情况
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value="/survey/{id}")
    public StuHabits showHabits(@PathVariable("id") int id){
        return habitsService.getHabits(id);
    }
}
