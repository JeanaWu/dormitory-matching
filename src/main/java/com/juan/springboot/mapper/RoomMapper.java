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


    @Insert("insert into room(room,id,weight,building) values(#{room},#{id},#{weight},#{building} )")
    public void saveRoom(@Param("room") int room,@Param("id") int id,@Param("weight") int weight,@Param("building") int building);

    @Select("select room,room.id,building,name,gender,weight,college from student,room where student.id=room.id")
    public ArrayList<Student> getAll();

    @Select("select id from room where id=#{id};")
    public String getIdByID(int id);

    @Select("select room from room where id=#{id};")
    public String getRoomById(int id);

    //查询表中最大的房间号
    @Select("select max(room) from room")
    public Integer getMaxRoom();

    @Select("select room,room.id,building,name,gender,weight,college from student,room where student.id=room.id and room=#{room}")
    public ArrayList<Student> findRoomByRoom(@Param("room") int room);


}
