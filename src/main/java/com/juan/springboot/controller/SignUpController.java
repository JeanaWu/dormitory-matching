package com.juan.springboot.controller;

import com.juan.springboot.mapper.StudentMapper;
import com.juan.springboot.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

/**
 * 学生基本的注册功能，将数据存放在数据库中
 * 需要完善：
 *
 *         id不唯一的时候返回错误提示  √
 *         注册界面的美化
 */
@Controller
public class SignUpController {

    @Autowired
    SignService signService;
    @Autowired
    StudentMapper studentMapper;
    /**
     * 学生跳转到注册页面
     */
    @GetMapping(value="/signup")
    public String toSignUp(){

        return "stu/signup";
    }

    /**
     * 学生信息注册
     */
    @PostMapping("/signup")
    public String signUp(@RequestParam("id") Integer id,
                     @RequestParam("password") String password,
                     @RequestParam("name") String name,
                     @RequestParam("gender") Integer gender,
                     @RequestParam("birth") Date birth,
                     @RequestParam("college") String college,
                     @RequestParam("department") String department,
                         Map<String,Object> map) {

//        System.out.println(id + password + name + gender + birth + college + department);

       return signService.sign(id, password, name, gender, birth, college, department, map);

    }
}
