package com.juan.springboot.controller;

import com.juan.springboot.bean.Student;
import com.juan.springboot.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class RoommateController {
    @Autowired
    RoommateService roommateService;

    @ResponseBody
    @GetMapping("/roommates/{id}")
    public ArrayList<Student> getRoommate(@PathVariable("id") Integer id){
        return roommateService.getRoommates(id);
    }

}
