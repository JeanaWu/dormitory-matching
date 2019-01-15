package com.wdjr.springboot.controller;


import com.wdjr.springboot.bean.Student;
import com.wdjr.springboot.dao.DepartmentDao;
import com.wdjr.springboot.dao.EmployeeDao;
import com.wdjr.springboot.entities.Department;
import com.wdjr.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

//@RestController
@Controller
public class PageController {

    @Autowired
    StudentMapper studentMapper;
//    DepartmentDao departmentDao;
//    EmployeeDao employeeDao;



    /**
     * 学生跳转到调查问卷页面
     */
    @GetMapping(value="/survey")
    public String toSurvey(){

        return "stu/survey";
    }

    /**
     * 学生跳转到结果页面
     */
    @GetMapping(value="/result")
    public String toResult(){

        return "stu/result";
    }
    /**
     * 学生跳转到个人信息
     */
    @GetMapping(value="/info")
    public String toInfo(){

        return "stu/info";
    }

    /**
     * 学生跳转到登录页面
     * 并销毁session
     */

    @GetMapping(value="/signOut")
    public String toLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
    /**
     * 学生跳转到注册页面
     */
    @GetMapping(value="/signup")
    public String toSignUp(){

        return "stu/signup";
    }
}
