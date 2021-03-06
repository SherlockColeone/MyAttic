package com.cn.bean;

/**
 * 	教学评价类
 * @author Sherlock
 *
 */
public class Evaluation {
	//id
	private Integer id;
	//教师工号
	private Integer teacherid;
	//学号
    private Integer studentid;
    //内容
    private String content;

    public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(Integer teacherid, Integer studentid, String content) {
		super();
		this.teacherid = teacherid;
		this.studentid = studentid;
		this.content = content;
	}

	public Evaluation(Integer id, Integer teacherid, Integer studentid, String content) {
		super();
		this.id = id;
		this.teacherid = teacherid;
		this.studentid = studentid;
		this.content = content;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", teacherid=" + teacherid + ", studentid=" + studentid + ", content=" + content
				+ "]";
	}
}