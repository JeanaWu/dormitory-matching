package com.juan.springboot.mapper;


import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import com.juan.springboot.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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

    @Select("select * from student")
    public Collection<Student> getAll();

    @Update("update student set  password=#{password},name=#{name},gender=#{gender},birth=#{birth},college=#{college},department=#{department} where id=#{id} ")
    public void adUpdateInfo(@Param("id") Integer id,@Param("password") String password, @Param("name")String name,
                           @Param("gender")Integer gender,@Param("birth") Date birth, @Param("college")String college,
                           @Param("department")String department);


    /**
     * 获取女生信息集合
     */
    @Select("SELECT * from student,stu_habits where stu_habits.id=student.id AND student.gender=0")
    public ArrayList<Student> getFemale();

    /**
     * 获取男生信息集合
     */
    @Select("SELECT * from student,stu_habits where stu_habits.id=student.id AND student.gender=1")
    public ArrayList<Student> getMale();
}
