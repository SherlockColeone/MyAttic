package com.cn.bean;

public class Term {
    private Integer id;

    private String termtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermtime() {
        return termtime;
    }

    public void setTermtime(String termtime) {
        this.termtime = termtime == null ? null : termtime.trim();
    }
}