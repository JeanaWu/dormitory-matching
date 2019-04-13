package com.juan.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.juan.springboot.bean.Student;
import com.juan.springboot.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Controller
public class EditController {
    @Autowired
    InfoService infoService;

    /**
     * 页面跳转至单个学生信息的编辑
     */
    @ResponseBody
    @GetMapping(value="/edit/{id}")
    public Student toEditPage(@PathVariable("id") int id ){
        return infoService.showEdit(id);
    }



    /**
     * 保存更新后的学生信息并返回新的学生信息
     */
    @ResponseBody
    @RequestMapping(value = "/editInfo/{id}", method = RequestMethod.POST)
    public Object adSave (@PathVariable("id") int id,
                         @RequestBody String requestString
                         ){
//        System.out.println(requestString);
        Student student=new Gson().fromJson(requestString, new TypeToken<Student>(){}.getType());
//        System.out.println(student);
//        System.out.println(id);
        Integer newId=student.getId();
        String password=student.getPassword();
        String name=student.getName();
        Integer gender=student.getGender();
        Date birth=student.getBirth();
        String college=student.getCollege();
        String department=student.getDepartment();
        Object o = JSONObject.toJSON(infoService.adSave(newId,id,password,name,gender,birth,college,department));
      return o;

    }

    @ResponseBody
    @RequestMapping(value = "/stuEdit/{id}", method = RequestMethod.POST)
    public Object stuSave (@PathVariable("id") int id,
                          @RequestBody String requestString
    ){
//        System.out.println(requestString);
        Student student=new Gson().fromJson(requestString, new TypeToken<Student>(){}.getType());
//        System.out.println(student);
//        System.out.println(id);
        Integer newId=student.getId();
        String password=student.getPassword();
        String name=student.getName();
        Integer gender=student.getGender();
        Date birth=student.getBirth();
        String college=student.getCollege();
        String department=student.getDepartment();
        Object o = JSONObject.toJSON(infoService.adSave(id,password,name,gender,birth,college,department));
        return o;

    }

}
