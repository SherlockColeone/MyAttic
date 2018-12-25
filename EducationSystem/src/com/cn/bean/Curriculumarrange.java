package com.cn.bean;

/**
 * 	调课安排类
 * @author Sherlock
 *
 */
public class Curriculumarrange {
	//id
	private Integer id;
	//专业课id
	private Integer coursesid;
	//选修课id
	private Integer electiveid;
	//调课上课周次
	private String week;
	//调课上课星期
	private Integer day;
	//调课上课节数
	private String time;
	//上课地点
	private String place;
	//上课班级，若为0，说明是选修课
	private Integer classesid;
	//任课老师工号
	private Integer teacherid;
	//教务处是否批准，-1表示不批准、0表示未处理、1表示已批准
	private Integer permit;

    public Curriculumarrange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curriculumarrange(Integer id, Integer coursesid, Integer electiveid, String week, Integer day, String time,
			String place, Integer classesid, Integer teacherid, Integer permit) {
		super();
		this.id = id;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.week = week;
		this.day = day;
		this.time = time;
		this.place = place;
		this.classesid = classesid;
		this.teacherid = teacherid;
		this.permit = permit;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Integer getElectiveid() {
        return electiveid;
    }

    public void setElectiveid(Integer electiveid) {
        this.electiveid = electiveid;
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

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getPermit() {
        return permit;
    }

    public void setPermit(Integer permit) {
        this.permit = permit;
    }

	@Override
	public String toString() {
		return "Curriculumarrange [id=" + id + ", coursesid=" + coursesid + ", electiveid=" + electiveid + ", week="
				+ week + ", day=" + day + ", time=" + time + ", place=" + place + ", classesid=" + classesid
				+ ", teacherid=" + teacherid + ", permit=" + permit + "]";
	}
}