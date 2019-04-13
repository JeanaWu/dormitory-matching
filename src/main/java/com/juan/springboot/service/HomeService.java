package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.HabitsMapper;
import com.juan.springboot.mapper.InformationMapper;
import com.juan.springboot.mapper.RoomMapper;
import com.juan.springboot.mapper.StudentMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HomeService {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    HabitsMapper habitsMapper;
    @Autowired
    InformationMapper informationMapper;


    public Map homeInfo(){
        Integer stuNum=studentMapper.getNum();
        Integer surveyNum=habitsMapper.getNum();
        Integer roomNum=roomMapper.getNum();
        Integer infoNum=informationMapper.getNum();
        Map<String,Object> map=new HashMap<>();
        map.put("stuNum",stuNum);
        map.put("surveyNum",surveyNum);
        map.put("dormitory",roomNum);
        map.put("information",infoNum);
        return  map;
    }

    public ArrayList<Student> unfinishedInfo(){
        return studentMapper.getUnfinished();
    }



}
