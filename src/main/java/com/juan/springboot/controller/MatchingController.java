package com.juan.springboot.controller;

import com.juan.springboot.bean.Student;
import com.juan.springboot.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class MatchingController {
    @Autowired
    MatchingService matchingService;

    @GetMapping("/matching")
    public String toResult(){
        return matchingService.matching();
//       return "/adm/admain";

    }

    @GetMapping("/allresults")
    public String toResult(Model model,@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize ){
        matchingService.toResult(model,pageNum,pageSize);
        return "/adm/allresults";
    }

}
