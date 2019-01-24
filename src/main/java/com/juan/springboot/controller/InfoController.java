package com.juan.springboot.controller;

import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class InfoController {
    @Autowired
    InfoService infoService;

    /**
     * 学生跳转到个人信息
     */
    @GetMapping(value="/info")
    public String showInfo(Model model, HttpSession session){
        infoService.showInfo(model,session);
        return "stu/info";
    }

    /**
     * 学生信息更新
     */
    @PostMapping("/edit")
    public String editInfo(HttpSession session,
                           @RequestParam("name") String name,
                           @RequestParam("gender") Integer gender,
                           @RequestParam("birth") Date birth,
                           @RequestParam("college") String college,
                           @RequestParam("department") String department,
                           Map<String, Object> map){

       return infoService.editInfo(session,name,gender,birth,college,department,map);
    }
}
