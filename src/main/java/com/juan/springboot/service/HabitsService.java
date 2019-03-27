package com.juan.springboot.service;

import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.HabitsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HabitsService {
    @Autowired
    HabitsMapper habitsMapper;


    public StuHabits getHabits(int id){
        StuHabits hbt=habitsMapper.getHabitsByID(id);
      return hbt;

    }
}
