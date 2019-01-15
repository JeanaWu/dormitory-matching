package com.wdjr.springboot.mapper;


import com.wdjr.springboot.bean.StuHabits;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface HabitsMapper {

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
}
