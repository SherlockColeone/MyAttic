package com.cn.bean;

public class Gradecet {
    private Integer id;

    private Integer studentid;

    private String cetid;

    private String cettime;

    private Integer cetscore;

    private Integer classroomid;

    private Integer teacherid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getCetid() {
        return cetid;
    }

    public void setCetid(String cetid) {
        this.cetid = cetid == null ? null : cetid.trim();
    }

    public String getCettime() {
        return cettime;
    }

    public void setCettime(String cettime) {
        this.cettime = cettime == null ? null : cettime.trim();
    }

    public Integer getCetscore() {
        return cetscore;
    }

    public void setCetscore(Integer cetscore) {
        this.cetscore = cetscore;
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}