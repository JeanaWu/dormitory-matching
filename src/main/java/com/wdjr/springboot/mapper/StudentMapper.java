package com.wdjr.springboot.mapper;


import com.wdjr.springboot.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

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
}
