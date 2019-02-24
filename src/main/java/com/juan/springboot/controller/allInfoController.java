package com.juan.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juan.springboot.bean.Student;
import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class allInfoController {
    @Autowired
    InfoService infoService;
    /**
     * 页面跳转至显示全部学生信息
     */
    @GetMapping(value="/allinfo")
    public String  toAllInfo(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize ){
//        PageHelper.startPage(pageNum,pageSize);
//
//
//        ArrayList<Student>students =infoService.showAllInfo();
//
//        PageInfo<Student> pageInfo= new PageInfo<>(students);
//        model.addAttribute("pageInfo",pageInfo);
//
//        return "/adm/allinfo";
        return infoService.showAllInfo(model,pageNum,pageSize);

    }
//    @ResponseBody
//    @GetMapping(value="/allinfo")
//    public Collection<Student> toAllInfo(){
//        return infoService.showAllInfo();
//    }









}
