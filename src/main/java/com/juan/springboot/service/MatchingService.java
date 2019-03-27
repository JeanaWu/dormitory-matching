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





//将女存储到list中，进行排序，（移除已经含有room的学生）
    public void fMatching(){
        ArrayList<Student> female=studentMapper.getFemale();
        ArrayList<StuHabits> fhbt=habitsMapper.getFemale();

        for(int i=0;i<female.size();i++){

           female.get(i).setStuHabits(fhbt.get(i));
          }

        Greedy greedy=new Greedy();
        greedy.getWeight(female);
        greedy.greedyFSelector(female,roomMapper);



    }

    //将男存储到list中，进行排序，（移除已经含有room的学生）
    public void mMatching() {
        ArrayList<Student> male = studentMapper.getMale();
        ArrayList<StuHabits> mhbt = habitsMapper.getMale();

        for (int i = 0; i < male.size(); i++) {
            male.get(i).setStuHabits(mhbt.get(i));
        }

        Greedy greedy = new Greedy();

        greedy.getWeight(male);
        greedy.greedyMSelector(male,roomMapper);

    }

    public ArrayList<Student> toFResult (){

      ArrayList<Student>students =roomMapper.getFAll();
        return students;
    }

    public ArrayList<Student> toMResult (){

        ArrayList<Student>students =roomMapper.getMAll();
        return students;
    }
}
