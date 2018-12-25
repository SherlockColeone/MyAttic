package com.cn.bean;

/**
 * 	选课报名记录类
 * @author Sherlock
 *
 */
public class Tempelective {
	//id
	private Integer id;
	//选修课id
	private Integer electiveid;
	//学号
	private Integer studentid;

    public Tempelective() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tempelective(Integer electiveid, Integer studentid) {
		super();
		this.electiveid = electiveid;
		this.studentid = studentid;
	}

	public Tempelective(Integer id, Integer electiveid, Integer studentid) {
		super();
		this.id = id;
		this.electiveid = electiveid;
		this.studentid = studentid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

	@Override
	public String toString() {
		return "Tempelective [id=" + id + ", electiveid=" + electiveid + ", studentid=" + studentid + "]";
	}
}