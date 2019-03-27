package com.juan.springboot.mapper;

import com.juan.springboot.bean.Information;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface InformationMapper {

    //增加信息
    @Insert("insert into information(num,content,date) values(default ,#{content},#{date})")
    public void addInformation(@Param("content") String content,@Param("date")Date date);


    @Select("select * from information order by num desc ")
    public ArrayList<Information> getAll();

    @Delete("delete from information where num = #{num}")
    public void delete(@Param("num")  Integer num);

    /**
     * 获取公告发布数量
     */
    @Select("select count(*) from information")
    public Integer getNum();
}
