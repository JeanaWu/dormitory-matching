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
import java.util.HashMap;
import java.util.Map;

@Controller
public class allInfoController {
    @Autowired
    InfoService infoService;
    /**
     * 查询并显示全部学生信息
     */
    @ResponseBody
    @GetMapping(value="/allinfo")
    public Map toAllInfo( ){
        ArrayList<Student> students=infoService.showAllInfo();
        Map<String,Object> map= new HashMap<>();
        map.put("total",students.size());
        map.put("rows",students);
        return map;
    }

}
