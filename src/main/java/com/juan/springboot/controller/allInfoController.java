package com.juan.springboot.controller;

import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
