package com.juan.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public class FindService {
    @Autowired
    RoomMapper roomMaper;


    public void findRoomByRoom(Integer room,Model model, Integer pageNum,
                               Integer pageSize ){
        System.out.println(room);
        System.out.println("========");
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Student> students= roomMaper.findRoomByRoom(room);
        System.out.println(students);
        PageInfo<Student> pageInfo=new PageInfo<>(students);
        model.addAttribute("pageInfo",pageInfo);

    }
//    public void findRoomByRoom(Integer room){
//        System.out.println(room);
//        ArrayList<Student> students= roomMaper.findRoomByRoom(room);
//        System.out.println(students);
//    }
}

