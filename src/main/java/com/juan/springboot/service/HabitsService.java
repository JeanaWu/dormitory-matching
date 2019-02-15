package com.juan.springboot.service;

import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.mapper.HabitsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HabitsService {
    @Autowired
    HabitsMapper habitsMapper;


    public String getHabits(Model model,int id){
        StuHabits hbt=habitsMapper.getHabitsByID(id);
        model.addAttribute("hbt",hbt);
        return "/adm/habits";
    }
}
