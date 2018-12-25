package com.cn.bean;

/**
 * 	专业课程类
 * @author Sherlock
 *
 */
public class Courses {
	//专业课id
    private Integer id;
	//专业课名称
	private String name;
	//上课周次：x-y周
	private String week;
	//星期：1-7分别是星期一至星期日
	private int day;
	//上课节数：x-y(个位数用0x表示，如03-04)
	private String time;
	//上课地点
	private String place;
	//任课老师
	private String teacher;	
	//班级id
	private Integer classesid;
	//学期id
	private Integer termid;	
	//任课老师id
	private Integer teacherid;
	
    public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(Integer id, String name, String week, int day, String time, String place, String teacher,
			Integer classesid, Integer termid, Integer teacherid) {
		super();
		this.id = id;
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.teacher = teacher;
		this.classesid = classesid;
		this.termid = termid;
		this.teacherid = teacherid;
	}

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", week=" + week + ", day=" + day + ", time=" + time
				+ ", place=" + place + ", teacher=" + teacher + ", classesid=" + classesid + ", termid=" + termid
				+ ", teacherid=" + teacherid + "]";
	}
}