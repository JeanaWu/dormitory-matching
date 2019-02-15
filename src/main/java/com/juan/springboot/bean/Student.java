package com.juan.springboot.bean;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String password;
    private Integer gender;
    private Date birth;
    private String college;
    private String department;
    private StuHabits stuHabits;
    private Integer weight;
    private Integer difference;
    private Integer room;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", stuHabits=" + stuHabits +
                ", weight=" + weight +
                ", difference=" + difference +
                ", room=" + room +
                '}';
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StuHabits getStuHabits() {
        return stuHabits;
    }

    public void setStuHabits(StuHabits stuHabits) {
        this.stuHabits = stuHabits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
