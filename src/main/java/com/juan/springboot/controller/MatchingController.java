package com.juan.springboot.controller;

import com.juan.springboot.bean.Student;
import com.juan.springboot.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class MatchingController {
    @Autowired
    MatchingService matchingService;

    @GetMapping("/matching")
    public String toResult(){
       matchingService.matching();
       return "/adm/admain";

    }

    @GetMapping("/allresults")
    public String toResult(Model model){
        matchingService.toResult(model);
        return "/adm/allresults";
    }

}
