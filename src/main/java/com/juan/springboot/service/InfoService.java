package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;

@Service
public class InfoService {
    @Autowired
    StudentMapper studentMapper;

    public void showInfo(Model model, HttpSession session){
        int id = (int) session.getAttribute("id");
        Student stuInfo = studentMapper.getStuByID(id);
        model.addAttribute("info",stuInfo);

    }

    public String editInfo(HttpSession session, String name, int gender, Date birth,String college,String department){
        Integer id = (Integer) session.getAttribute("id");
        studentMapper.updateInfo(id,name,gender,birth,college,department);
        return "Dashboard";

    }
}
