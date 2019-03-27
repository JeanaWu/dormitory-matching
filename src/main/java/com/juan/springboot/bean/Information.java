package com.juan.springboot.bean;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;

public class Information {
    private Integer num;
    private String content;
    private Date date;

    public Integer getNum() {
        return num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
