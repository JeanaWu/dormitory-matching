package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import com.juan.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.getType;
/**
 * 登录控制，如果账号是000000，密码是123456则是管理员账号进入管理员界面（管理员先不写）
 * 账号为数据库中相应的学生id和密码则进入学生界面
 * 账号不存在则提示用户不存在---跳转到注册界面
 * 账号密码错误则提示密码错误
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
//    /**
//     * 编写方法判断id类型
//     */
//    public static String getType(Object o){ //获取变量类型方法
//        return o.getClass().toString(); //使用int类型的getClass()方法
//    }
    @ResponseBody
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public Object login(@RequestBody String requestString) {
        Student student=new Gson().fromJson(requestString, new TypeToken<Student>(){}.getType());
        Integer id=student.getId();
        String password=student.getPassword();
        Object o = JSONObject.toJSON(loginService.login(id,password));
        System.out.println(o);
       return o;
    }
}
