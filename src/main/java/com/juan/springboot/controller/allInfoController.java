package com.juan.springboot.controller;

import com.juan.springboot.bean.Student;
import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class allInfoController {
    @Autowired
    InfoService infoService;
    /**
     * 页面跳转至显示全部学生信息
     */
    @GetMapping(value="/allinfo")
    public String  toAllInfo(Model model){
        infoService.showAllInfo(model);
        return "/adm/allinfo";

    }
//    @ResponseBody
//    @GetMapping(value="/allinfo")
//    public Collection<Student> toAllInfo(){
//        return infoService.showAllInfo();
//    }







}
