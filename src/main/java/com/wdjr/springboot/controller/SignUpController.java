package com.wdjr.springboot.controller;

import com.wdjr.springboot.mapper.StudentMapper;
import com.wdjr.springboot.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
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
        String stuPassword=signService.getPassword(id);
        try {
            //try块中放可能发生异常的代码。
            signService.sign(id, password, name, gender, birth, college, department);
        } catch (Exception exception) {
            if (stuPassword!= null) {
                map.put("emsg", "该学号已注册，若不是本人请和管理员联系");
                return "/stu/signup";
            }
        }
        map.put("msg", "注册成功,请登录");
        return "login";
    }
}
