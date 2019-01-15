package com.juan.springboot.controller;

import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    StudentMapper studentMapper;
//    /**
//     * 编写方法判断id类型
//     */
//    public static String getType(Object o){ //获取变量类型方法
//        return o.getClass().toString(); //使用int类型的getClass()方法
//    }
    @PostMapping(value ="/user/login")
    public String login(@RequestParam("id")int id,
                        @RequestParam("password")String password,
                        Map<String,Object> map,
                        HttpSession session) {
        if (000000==id && "123456".equals(password)) {
            //登录成功,防止重复提交
//            System.out.println(getType(id));
            session.setAttribute("loginUser", "管理员");

            return "redirect:/main.html";//之后记得修改为跳转到管理员界面
        } else if (password.equals(studentMapper.findPasswordbyId(id))) {

            session.setAttribute("loginUser", "你好："+studentMapper.getStuByID(id).getName());
            session.setAttribute("id",id);
            return "redirect:/main.html";
        } else if (studentMapper.findPasswordbyId(id) == null) {

            map.put("msg", "用户不存在");
            return "login";
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
