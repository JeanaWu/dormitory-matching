package com.juan.springboot.controller;

import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EditController {
    @Autowired
    InfoService infoService;

    /**
     * 页面跳转至单个学生信息的编辑
     */
    @GetMapping(value="/edit/{id}")
    public String toEditPage(@PathVariable("id") int id ,Model model){
        return infoService.showEdit(id,model);
    }

    /**
     * 保存更新后的学生信息并返回全部学生信息页面
     */

    @PostMapping("/edit/{id}")
    public String adSave(@PathVariable("id") Integer id,
                         @RequestParam("password") String password,
                         @RequestParam("name") String name,
                         @RequestParam("gender") Integer gender,
                         @RequestParam("birth") Date birth,
                         @RequestParam("college") String college,
                         @RequestParam("department") String department,
                         Model model){
        return infoService.adSave(id,password,name,gender,birth,college,department,model);

    }
}
