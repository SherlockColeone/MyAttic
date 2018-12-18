package com.cn.bean;

public class Stuscore {
    private Integer id;

    private Integer studentid;

    private String coursename;

    private String score;

    private Integer credit;

    private Double point;

    private Integer termid;

    private Integer couresid;

    private Integer electiveid;

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

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Integer getCouresid() {
        return couresid;
    }

    public void setCouresid(Integer couresid) {
        this.couresid = couresid;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
    }
}