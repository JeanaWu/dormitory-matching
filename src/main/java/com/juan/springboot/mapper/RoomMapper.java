package com.juan.springboot.mapper;

import com.juan.springboot.bean.Room;
import com.juan.springboot.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;

@Mapper
public interface RoomMapper {


    @Insert("insert into room(room,id,weight,building) values(#{room},#{id},#{weight},#{building} )")
    public void saveRoom(@Param("room") int room,@Param("id") int id,@Param("weight") int weight,@Param("building") int building);

    @Select("select room,room.id,building,name,gender,weight,college from student,room where student.id=room.id AND gender=0")
    public ArrayList<Student> getFAll();

    @Select("select room,room.id,building,name,gender,weight,college from student,room where student.id=room.id AND gender=1")
    public ArrayList<Student> getMAll();

    @Select("select id from room where id=#{id};")
    public String getIdByID(int id);

    @Select("select room from room where id=#{id};")
    public String getRoomById(int id);

    //查询表中最大的房间号
    @Select("select max(room) from room where building=1")
    public Integer getmMaxRoom();

    @Select("select max(room) from room where building=0")
    public Integer getfMaxRoom();

    @Select("select room,room.id,building,name,gender,weight,college from student,room where student.id=room.id and room=#{room}")
    public ArrayList<Student> findRoomByRoom(@Param("room") int room);

    @Select("select count(*) from room")
    public Integer getNum();

    //查询学生的房间
    @Select("select room from room where id=#{id}")
    public Integer findRoomById(@Param("id") Integer id);

    //查询同一间宿舍学生信息
    @Select("select room,room.id,name,department,college from student,room where room=#{room} and student.id=room.id;")
    public ArrayList<Student> getRoommates(@Param("room") Integer room);
}
