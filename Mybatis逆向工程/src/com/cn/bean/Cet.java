package com.cn.bean;

public class Cet {
    private Integer id;

    private String cetname;

    private String cettime;

    private Integer termid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCetname() {
        return cetname;
    }

    public void setCetname(String cetname) {
        this.cetname = cetname == null ? null : cetname.trim();
    }

    public String getCettime() {
        return cettime;
    }

    public void setCettime(String cettime) {
        this.cettime = cettime == null ? null : cettime.trim();
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }
}