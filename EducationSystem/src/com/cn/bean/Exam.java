package com.cn.bean;

/**
 * 	øº ‘¿‡
 * @author Sherlock
 *
 */
public class Exam {
	//øº ‘id
	private Integer id;
	//øº ‘µÿµ„
	private String place;
	//øº ‘ ±º‰
	private String examtime;
	//øº ‘øŒ≥Ãid
	private Integer coursesid;
	//º‡øº¿œ ¶id
	private Integer teacherid;
	//øº ‘∞‡º∂id
	private Integer classesid;

    public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam(Integer id, String place, String examtime, Integer coursesid, Integer teacherid, Integer classesid) {
		super();
		this.id = id;
		this.place = place;
		this.examtime = examtime;
		this.coursesid = coursesid;
		this.teacherid = teacherid;
		this.classesid = classesid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime == null ? null : examtime.trim();
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

	@Override
	public String toString() {
		return "Exam [id=" + id + ", place=" + place + ", examtime=" + examtime + ", coursesid=" + coursesid
				+ ", teacherid=" + teacherid + ", classesid=" + classesid + "]";
	}
}