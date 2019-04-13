package com.juan.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

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
     *  学生更新学生信息
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
    public ArrayList<Student> showAllInfo() {
        ArrayList<Student>students =studentMapper.getAll();
        return students;


    }

    /**
     *  管理员显示学生信息
     */
    public Student showEdit(int id){
        System.out.println(id);
        Student stuInfo = studentMapper.getStuByID(id);
      return stuInfo;
    }

    /**
     * 学生员保存学生信息
     * 显示并返回全部学生信息
     */
    public Map adSave(Integer id, String password, String name, Integer gender, Date birth, String college, String department) {
        Map<String, Object> map = new HashMap<>();
        try {

            studentMapper.UpdateInfo(id, password, name, gender, birth, college, department);
            map.put("msg", "学生信息更新成功");

            return map;

        } catch (Exception e) {
            map.put("msg", "学生信息更新失败");

            return map;
        }
    }


    /**
     * 管理员保存学生信息
     * 显示并返回全部学生信息
     */

    public Map adSave(Integer newId,Integer id, String password, String name, Integer gender, Date birth, String college, String department) {
        Map<String, Object> map = new HashMap<>();
        try {

                studentMapper.adUpdateInfo(newId,id, password, name, gender, birth, college, department);
                map.put("msg", "学生信息更新成功");

                return map;

        } catch (Exception e) {
            map.put("msg", "学生信息更新失败");

            return map;
        }
    }


}
