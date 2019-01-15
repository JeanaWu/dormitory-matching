package com.juan.springboot.controller;


import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.HabitsMapper;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TsqlController {
    @Autowired
    HabitsMapper habitsMapper;
    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/hbt/{id}")
    public StuHabits getHabitsById(@PathVariable("id") Integer id){
        return habitsMapper.getHabitsByID(id);

    }

    @GetMapping("/aaa/{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentMapper.getStuByID(id);
    }


    @GetMapping("/bbb/{id}")
    public int getPassword(@PathVariable("id") Integer id){
        return studentMapper.getStuByID(id).getId();
    }

    @GetMapping(value="/ccc/{id}/{password}/{name}/{gender}/{birth}/{college}/{department}")
    public String add(@PathVariable("id") Integer id,
                      @PathVariable("password") String password,
                      @PathVariable("name") String name,
                      @PathVariable("gender") Integer gender,
                      @PathVariable("birth") Date birth,
                      @PathVariable("college") String college,
                      @PathVariable("department") String department){
         studentMapper.addStudent(id, password, name, gender, birth, college, department);
         return "success";
    }
}
