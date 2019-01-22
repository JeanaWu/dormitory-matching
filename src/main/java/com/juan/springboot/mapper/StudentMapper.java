package com.juan.springboot.mapper;


import com.juan.springboot.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.Date;

//指定这是一个操作数据库的mapper
//@Mapper
public interface StudentMapper {

    @Select("select * from student where id=#{id}")
    public Student getStuByID(Integer id);

    @Delete("delete from student where id=#{id}")
    public int deleteStuById(Integer id);

    @Select("select password from student where id=#{id}")
    public String findPasswordbyId( Integer id);

    @Insert("insert into student(id,password,name,gender,birth,college,department) values(#{id},#{password},#{name},#{gender},#{birth},#{college},#{department}) ")
    public void addStudent(@Param("id") Integer id, @Param("password") String password, @Param("name")String name,
                           @Param("gender")Integer gender,@Param("birth") Date birth, @Param("college")String college,
                           @Param("department")String department);

    @Update("update student set name=#{name},gender=#{gender},birth=#{birth},college=#{college},department=#{department} where id=#{id} ")
    public void updateInfo(@Param("id") Integer id, @Param("name")String name,
                           @Param("gender")Integer gender,@Param("birth") Date birth, @Param("college")String college,
                           @Param("department")String department);
}
