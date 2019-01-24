package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Service
public class InfoService {
    @Autowired
    StudentMapper studentMapper;

    /**
     * 显示单个学生信息
     */
    public void showInfo(Model model, HttpSession session){
        int id = (int) session.getAttribute("id");
        Student stuInfo = studentMapper.getStuByID(id);
        model.addAttribute("info",stuInfo);

    }

    /**
     * 更新学生信息
     */
    public String editInfo(HttpSession session, String name, int gender, Date birth, String college, String department, Map<String, Object> map){
        Integer id = (Integer) session.getAttribute("id");
        studentMapper.updateInfo(id,name,gender,birth,college,department);
        map.put("msg","信息更新成功");
        return "/stu/Dashboard";

    }

    /**
     * 显示全部学生信息
     */
    public void showAllInfo(Model model){
        Collection<Student> students=studentMapper.getAll();
        model.addAttribute("students",students);
    }
}
