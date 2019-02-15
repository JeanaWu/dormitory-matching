package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.RoomMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.*;

@Service
public class Greedy {
    int room=100;


    @Autowired
    RoomMapper roomMapper;



    /**
     * 获取学生的权重并存保存在students中
     */
    public void getWeight(ArrayList<Student> students){
        System.out.println(students.size());
       for(int i=0;i<students.size();i++){
          int stuWeight= students.get(i).getStuHabits().getSlpTime()*10
                   + students.get(i).getStuHabits().getGupTime()*8
                   + students.get(i).getStuHabits().getSlpNoisy()*5
                   + students.get(i).getStuHabits().getSlpHabits()*6
                   + students.get(i).getStuHabits().getClean()*4
                   + students.get(i).getStuHabits().getGames()*4
                   + students.get(i).getStuHabits().getAtmos()*3
                   + students.get(i).getStuHabits().getCharacters()*2;
           System.out.println(stuWeight);
           students.get(i).setWeight(stuWeight);
           System.out.println("==============rrrrrrrrrr===========");
       }
    }

    /**
     * 随机取出一个学生，并排序
     */
    public void greedySelector(ArrayList<Student> students){
        //获取标准值
        Random random = new Random();
        System.out.println("======11111=======");
        for (int i=0;i<students.size();i++) {

            int n = random.nextInt(students.size());
            int stander = students.get(n).getWeight();
            //计算和标准的差值

            System.out.println("======222=======");
            for (int j = 0; j < students.size(); j++) {
                int difference = (Math.abs(stander - students.get(j).getWeight()));
                students.get(j).setDifference(difference);
            }
            //根据和标准的差值排序
           Collections.sort(students, Comparator.comparing(Student::getDifference));
            System.out.println(students);

                room++;
                for (int m = 0; m < 4; m++) {
                    if(students.size()!=0) {
                        students.get(0).setRoom(room);

                        //存储到数据库room表中
                        roomMapper.saveRoom(students.get(0).getRoom(), students.get(0).getId(), students.get(0).getWeight());

                        //移除students第一位元素
                        students.remove(0);
                    }
                }

        }

    }



}
