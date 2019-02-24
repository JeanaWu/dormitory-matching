package com.juan.springboot.controller;

import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

//@RestController
@Controller
public class PageController {

    @Autowired
    StudentMapper studentMapper;
//    DepartmentDao departmentDao;
//    EmployeeDao employeeDao;





    /**
     * 学生跳转到结果页面
     */
    @GetMapping(value="/result")
    public String toResult(){

        return "stu/result";
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
     * 权限申请页面-审批页面
     */
}
