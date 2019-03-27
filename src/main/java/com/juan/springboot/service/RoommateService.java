package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.RoomMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class RoommateService {
    @Autowired
    RoomMapper roomMapper;

    public ArrayList<Student> getRoommates(Integer id){
        Integer room=roomMapper.findRoomById(id);
        ArrayList<Student> roommates=roomMapper.getRoommates(room);
        return  roommates;
    }

}
