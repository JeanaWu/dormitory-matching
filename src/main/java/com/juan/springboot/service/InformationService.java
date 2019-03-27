package com.juan.springboot.service;

import com.juan.springboot.bean.Information;
import com.juan.springboot.mapper.InformationMapper;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class InformationService {
    @Autowired
    InformationMapper informationMapper;

    //增加公告
    public Map addInformation(String content, Date date){
         Map<String,Object> map=new HashMap<>();
        informationMapper.addInformation(content,date);
        map.put("msg","公告发布成功");
        return map;
    }

    //显示全部公告信息
    public ArrayList<Information> getAll(){
        return informationMapper.getAll();
    }

    //删除信息
    public Map deleteInformation(Integer num){
        Map<String,Object> map = new HashMap<>();
        informationMapper.delete(num);
        map.put("msg","删除成功");
        return map;
    }

}
