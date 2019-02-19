package com.juan.springboot.service;

import com.juan.springboot.Algorithm.Greedy;
import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.HabitsMapper;
import com.juan.springboot.mapper.RoomMapper;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public void matching(){
        ArrayList<Student> female=studentMapper.getFemale();
        ArrayList<StuHabits> fhbt=habitsMapper.getFemale();

        ArrayList<Student> male=studentMapper.getMale();
        ArrayList<StuHabits> mhbt=habitsMapper.getMale();

        //将已分配宿舍的学生从列表删除
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
//        System.out.println("==================");
    }

    public void toResult(Model model){
        Collection<Student> students=roomMapper.getAll();
        model.addAttribute("stu",students);

    }
}
