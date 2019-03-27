package com.juan.springboot.controller;

import com.juan.springboot.bean.Student;

import com.juan.springboot.service.MatchingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MatchingController {
    @Autowired
    MatchingService matchingService;

    /**
     * 分配女生宿舍
     */
    @ResponseBody
    @GetMapping("/fMatch")
    public void fMatching() {
        matchingService.fMatching();
    }

    /**
     * 分配男生宿舍
     */
    @ResponseBody
    @GetMapping("/mMatch")
    public void mMatching() {
        matchingService.mMatching();
    }

    /**
     * 查询女生宿舍分配结果
     */
    @ResponseBody
    @GetMapping("/fAllResults")
    public Map toFResult() {
        ArrayList<Student> students = matchingService.toFResult();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", students.size());
        map.put("rows", students);
        return map;
    }

    /**
     * 查询男生宿舍分配结果
     */
    @ResponseBody
    @GetMapping("/mAllResults")
    public Map toMResult() {
        ArrayList<Student> students = matchingService.toMResult();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", students.size());
        map.put("rows", students);
        return map;
    }

}
