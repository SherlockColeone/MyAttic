package com.cn.bean;

public class Major {
    private Integer id;

    private String name;

    private Integer academyid;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }
}