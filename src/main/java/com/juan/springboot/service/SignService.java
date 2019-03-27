package com.juan.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class SignService {
    @Autowired
    StudentMapper studentMapper;


    /**
     * 注册功能，不允许重复注册，允许有数据字段为空
     */
    public Map sign(Integer id, String password, String name, Integer gender, Date birth, String college, String department, Map<String, Object> map) {
        Integer newid =studentMapper.findIdbyId(id);
        try {
            if(name.isEmpty()||password.isEmpty()||gender==null||birth==null||college.isEmpty()||department.isEmpty()){
                map.put("msg","有请填写全部数据");


            }else{
            studentMapper.addStudent(id, password, name, gender, birth, college, department);
            map.put("msg", "注册成功,请登录");


            }

        } catch (Exception E) {
            if (newid!= null) {
                map.put("msg", "该学号已注册");


            }
            else {
                map.put("msg","填写有误");
                System.out.println(map);


            }
        }
        return map;

    }

}
