package com.juan.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
//    public Collection<Student> showAllInfo(){
////        Collection<Student> students=studentMapper.getAll();
////        model.addAttribute("students",students);
//       Collection<Student> students=studentMapper.getAll();
//       return students;
//    }

    public String showAllInfo(Model model,Integer pageNum,Integer pageSize) {
//      ArrayList<Student> students=studentMapper.getAll();
//      return students;

        PageHelper.startPage(pageNum,pageSize);


        ArrayList<Student>students =studentMapper.getAll();

        PageInfo<Student> pageInfo= new PageInfo<>(students);
        model.addAttribute("pageInfo",pageInfo);

        return "/adm/allinfo";
    }

    /**
     *  管理员显示学生信息
     */
    public String showEdit(int id,Model model){
        System.out.println(id);
        Student stuInfo = studentMapper.getStuByID(id);
        model.addAttribute("stu",stuInfo);
        return "/adm/edinfo";
    }
    /**
     * 管理员保存学生信息
     * 显示并返回全部学生信息
     */

    public String adSave(int id,String password,String name, int gender, Date birth, String college, String department,Model model,
                         Integer pageNum,Integer pageSize){

        studentMapper.adUpdateInfo(id,password,name,gender,birth,college,department);
       this.showAllInfo(model,pageNum,pageSize);
        return "/adm/allinfo";
    }
}
