package com.cn.bean;

/**
 * 	学生社会考试记录类
 * @author Sherlock
 *
 */
public class Enrollcet {
	//id
	private Integer id;
	//社会考试名称id
	private Integer cetid;
	//考生考号
	private Integer studentid;

    public Enrollcet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollcet(Integer cetid, Integer studentid) {
		super();
		this.cetid = cetid;
		this.studentid = studentid;
	}

	public Enrollcet(Integer id, Integer cetid, Integer studentid) {
		super();
		this.id = id;
		this.cetid = cetid;
		this.studentid = studentid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCetid() {
        return cetid;
    }

    public void setCetid(Integer cetid) {
        this.cetid = cetid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

	@Override
	public String toString() {
		return "Enrollcet [id=" + id + ", cetid=" + cetid + ", studentid=" + studentid + "]";
	}
}