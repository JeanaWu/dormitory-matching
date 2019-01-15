package com.wdjr.springboot.bean;

public class Student {
    private Integer id;
    private String name;
    private String password;
    private Integer gender;
    private String birth;
    private String college;
    private String department;

    public StuHabits getStuHabits() {
        return stuHabits;
    }

    public void setStuHabits(StuHabits stuHabits) {
        this.stuHabits = stuHabits;
    }

    private StuHabits stuHabits;

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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
