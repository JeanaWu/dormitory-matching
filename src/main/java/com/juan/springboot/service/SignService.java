package com.juan.springboot.service;

import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignService {
    @Autowired
    StudentMapper studentMapper;

    public String  getPassword(Integer id){

       return studentMapper.findPasswordbyId(id);
    }

    public void sign(Integer id, String password, String name, Integer gender, Date birth, String college, String department){


        studentMapper.addStudent(id,password,name,gender,birth,college,department);
    }
}
