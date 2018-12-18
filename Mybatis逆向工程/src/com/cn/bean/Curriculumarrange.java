package com.cn.bean;

public class Curriculumarrange {
    private Integer id;

    private Integer coursesid;

    private Integer electiveid;

    private String week;

    private Integer day;

    private String time;

    private String place;

    private Integer classesid;

    private Integer teacherid;

    private Integer permit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }
}