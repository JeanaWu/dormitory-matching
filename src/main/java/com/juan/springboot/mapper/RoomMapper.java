package com.juan.springboot.mapper;

import com.juan.springboot.bean.Room;
import com.juan.springboot.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Mapper
public interface RoomMapper {


    @Insert("insert into room(room,id,weight) values(#{room},#{id},#{weight})")
    public void saveRoom(@Param("room") int room,@Param("id") int id,@Param("weight") int weight);

    @Select("select room,room.id,name,gender,weight,college from student,room where student.id=room.id")
    public ArrayList<Student> getAll();

    @Select("select id from room where id=#{id};")
    public String getIdByID(int id);

    @Select("select room from room where id=#{id};")
    public String getRoomById(int id);
}
