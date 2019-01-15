package com.wdjr.springboot.service;

import com.wdjr.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
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
