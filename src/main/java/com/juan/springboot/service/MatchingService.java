package com.juan.springboot.service;

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





    public void matching(){
        ArrayList<Student> female=studentMapper.getFemale();
        ArrayList<StuHabits> fhbt=habitsMapper.getFemale();

        ArrayList<Student> male=studentMapper.getMale();
        ArrayList<StuHabits> mhbt=habitsMapper.getMale();

        for(int i=0;i<female.size();i++){
            female.get(i).setStuHabits(fhbt.get(i));
        }

        for(int i=0;i<male.size();i++){
            male.get(i).setStuHabits(mhbt.get(i));
        }
        System.out.println(female);
        System.out.println(male);
        System.out.println("==========qqqq========");
        System.out.println(female.get(1).getId());//表的级联操作没有做好，habits不会自动存贮到对应的student中
        System.out.println("==========qqqq========");

        Greedy greedy=new Greedy();
        greedy.getWeight(female);
        greedy.greedySelector(female);

        greedy.getWeight(male);
        greedy.greedySelector(male);
        System.out.println("==================");
    }

    public void toResult(Model model){
        Collection<Student> students=roomMapper.getAll();
        model.addAttribute("stu",students);

    }
}
