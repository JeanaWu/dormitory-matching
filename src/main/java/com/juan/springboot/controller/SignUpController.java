package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import com.juan.springboot.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SignUpController {

    @Autowired
    SignService signService;
    @Autowired
    StudentMapper studentMapper;

    /**
     * 学生信息注册
     */
    @ResponseBody
    @PostMapping("/signup")
    public Object signUp( @RequestBody String requestString) {

        Student student=new Gson().fromJson(requestString, new TypeToken<Student>(){}.getType());

        Integer id=student.getId();
        String password=student.getPassword();
        String name=student.getName();
        Integer gender=student.getGender();
        Date birth=student.getBirth();
        String college=student.getCollege();
        String department=student.getDepartment();
        Map<String,Object> map=new HashMap<>();

        Object o = JSONObject.toJSON(signService.sign(id,password, name, gender, birth, college, department,map));
        System.out.println(o);
        return o;
    }
}
