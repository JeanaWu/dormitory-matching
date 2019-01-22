package com.juan.springboot.service;

import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class SignService {
    @Autowired
    StudentMapper studentMapper;



    public String sign(Integer id, String password, String name, Integer gender, Date birth, String college, String department, Map<String, Object> map) {
        String stuPassword = studentMapper.findPasswordbyId(id);
        try {
            studentMapper.addStudent(id, password, name, gender, birth, college, department);
        } catch (Exception E) {
            if (stuPassword != null) {
                map.put("emsg", "该学号已注册，若不是本人请和管理员联系");
                return "/stu/signup";
            }
        }
        map.put("msg", "注册成功,请登录");
        return "login";
    }

}
