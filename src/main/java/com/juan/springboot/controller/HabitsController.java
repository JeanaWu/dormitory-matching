package com.juan.springboot.controller;

import com.juan.springboot.service.HabitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HabitsController {
    @Autowired
    HabitsService habitsService;

    @GetMapping(value="/hbt/{id}")
    public String showHabits(@PathVariable("id") int id, Model model){
        return habitsService.getHabits(model,id);
    }
}
