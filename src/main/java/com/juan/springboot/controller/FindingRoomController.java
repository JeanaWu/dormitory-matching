package com.juan.springboot.controller;

import com.juan.springboot.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FindingRoomController {
    @Autowired
    FindService findService;

    @PostMapping("/findRoom")
    public String  findRoom(@RequestParam("findRoom") Integer room, Model model,@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize ){

        System.out.println("===========");
        System.out.println(room);
//
//        findService.findRoomByRoom(room);

      findService.findRoomByRoom(room,model,pageNum,pageSize);

      return "adm/allresults";


    }

}
