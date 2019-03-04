package com.juan.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juan.springboot.Algorithm.Greedy;
import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.HabitsMapper;
import com.juan.springboot.mapper.RoomMapper;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MatchingService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    HabitsMapper habitsMapper;




//将男女存储到list中，进行排序，（移除已经含有room的学生）
    public String matching(){
        ArrayList<Student> female=studentMapper.getFemale();
        ArrayList<StuHabits> fhbt=habitsMapper.getFemale();

        ArrayList<Student> male=studentMapper.getMale();
        ArrayList<StuHabits> mhbt=habitsMapper.getMale();


        for(int i=0;i<female.size();i++){
//            int id=female.get(i).getId();
//            if(roomMapper.getIdbyID(id)!=0) female.remove(i);
           female.get(i).setStuHabits(fhbt.get(i));
          }
//
        for(int i=0;i<male.size();i++){
//            int id=male.get(i).getId();
//            if(roomMapper.getIdbyID(id)!=0) male.remove(i);
           male.get(i).setStuHabits(mhbt.get(i));
           }
//        System.out.println(female);
//        System.out.println(male);
//        System.out.println("==========qqqq========");
//        System.out.println(female.get(1).getId());
//        System.out.println("==========qqqq========");

        Greedy greedy=new Greedy();
        greedy.getWeight(female);
        greedy.greedySelector(female,roomMapper);

        greedy.getWeight(male);
        greedy.greedySelector(male,roomMapper);
        return "/adm/admain";
//        System.out.println("==================");
    }

    public void toResult(Model model, Integer pageNum,Integer pageSize ){
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Student>students =roomMapper.getAll();
        PageInfo<Student> pageInfo=new PageInfo<>(students);
//        ArrayList<Student> students=roomMapper.getAll();
//        System.out.println(students);
//        ArrayList<Student> fstudents=new ArrayList<Student>();
//        ArrayList<Student> mstudents=new ArrayList<Student>();
//        for(int i=0;i<students.size();i++){
//            if (students.get(i).getGender()==0) fstudents.add(students.get(i));
//            else mstudents.add(students.get(i));
//        }
//        model.addAttribute("fstu",fstudents);
//        model.addAttribute("mstu",mstudents);
        model.addAttribute("pageInfo",pageInfo);
    }
}
