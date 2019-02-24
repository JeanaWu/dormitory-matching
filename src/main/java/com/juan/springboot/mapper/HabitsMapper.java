package com.juan.springboot.mapper;


import com.juan.springboot.bean.StuHabits;
import com.juan.springboot.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Collection;
@Mapper
public interface HabitsMapper {


    /**
     * 通过学号获取全部的学生问卷信息
     */
    @Select("select * from stu_habits where id=#{id}")
    public StuHabits getHabitsByID(Integer id);

    /**
     * 查找表中是否存了该学生的habits信息
     */
    @Select("select id from stu_habits where id=#{id}")
    public String getIdById(Integer id);

    /**
     * 向stu_habits中插入数据
     */
    @Insert ("insert into stu_habits(id,slp_time,gup_time,slp_noisy,slp_habits,clean,games,atmos,characters) values(#{id},#{slpTime},#{gupTime},#{slpNoisy},#{slpHabits},#{clean},#{games},#{atmos},#{characters})")
    public void addHabits(@Param("id") Integer id,@Param("slpTime") Integer slpTime,@Param("gupTime") Integer gupTime,
                          @Param("slpNoisy") Integer slpNoisy,@Param("slpHabits") Integer slpHabits,@Param("clean")Integer clean,
                          @Param("games") Integer games,@Param("atmos") Integer atmos,@Param("characters") Integer characters);


    /**
     * 获取女生信息集合
     */
    @Select("SELECT * from student,stu_habits where stu_habits.id=student.id AND student.gender=0")
    public ArrayList<StuHabits> getFemale();

    /**
     * 获取男生信息集合
     */
    @Select("SELECT * from student,stu_habits where stu_habits.id=student.id AND student.gender=1")
    public ArrayList<StuHabits> getMale();

}
