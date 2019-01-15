package com.wdjr.springboot.service;

import com.wdjr.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Service

public class LoginService {
//    @Autowired
//    StudentMapper studentMapper;
//    public boolean hasId(int id){
//
//        String password= studentMapper.findPasswordbyId(id);
//        if(StringUtils.isEmpty(password)){
//            return false;
//        }
//        else if(@RequestParam("password")String password==password){
//            return true;
//        }
//        else return false;


//    }
//    private int id;
//    private  String password;
//    StudentMapper studentMapper;
//    /**
//     * 获取填写的id
//     */
//    public void login(@RequestParam("id") int id,@RequestParam("password") String password) {
//        this.id = id;
//        this.password=password;
//        if(password==studentMapper.findPasswordbyId(id)){
//        }
//
//    }
}