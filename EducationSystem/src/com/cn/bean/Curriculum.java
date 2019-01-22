package com.cn.bean;

/**
 * 总课程类
 * 用途：该实体类放置专业课加选修课，也会用于放置其他实体类属性，作为一个数据的载体
 * 注意：不属于数据库表的类，仅仅为实体类
 * @author Sherlock
 *
 */
public class Curriculum {
	//课程id（专业课就是专业课id，选修课就是选修课id）
	private Integer id;
	//课程名称
	private String name;
	//上课周次
	private String week;
	//星期
	private Integer day;
	//上课节数
	private String time;
	//课程大节
	private Integer lesson;
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
	//专业课id，若为0，说明该课程不是专业课
	private Integer coursesid;
	//选修课id，若为0，说明该课程不是选修课
	private Integer electiveid;
	//班级名称
	private String classes;
	
	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//显示学生名单所需的班级、姓名、学号
	public Curriculum(Integer id, String name, String classes) {
		super();
		this.id = id;
		this.name = name;
		this.classes = classes;
	}

	//选修课所需的选修课id
	public Curriculum(String name, String time, String place, Integer electiveid) {
		super();
		this.name = name;
		this.time = time;
		this.place = place;
		this.electiveid = electiveid;
	}
	
	//专业课所需的专业课id和班级名称
	public Curriculum(String name, String time, String place, Integer coursesid, String classes) {
		super();
		this.name = name;
		this.time = time;
		this.place = place;
		this.coursesid = coursesid;
		this.classes = classes;
	}

	public Curriculum(Integer id, String name, String teacher, Integer classesid, Integer coursesid,
			Integer electiveid) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.classesid = classesid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
	}

	public Curriculum(String name, String time, String teacher, Integer coursesid, Integer electiveid) {
		super();
		this.name = name;
		this.time = time;
		this.teacher = teacher;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
	}

	public Curriculum(String name, String teacher, Integer termid, Integer teacherid, Integer coursesid,
			Integer electiveid) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.termid = termid;
		this.teacherid = teacherid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
	}

	public Curriculum(Integer id, String name, String week, Integer day, String time, Integer lesson, String place,
			String teacher, Integer termid, Integer teacherid, Integer coursesid, Integer electiveid) {
		super();
		this.id = id;
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.lesson = lesson;
		this.place = place;
		this.teacher = teacher;
		this.termid = termid;
		this.teacherid = teacherid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
	}
	
	//所有属性
	public Curriculum(Integer id, String name, String week, Integer day, String time, Integer lesson, String place,
			String teacher, Integer classesid, Integer termid, Integer teacherid, Integer coursesid, Integer electiveid,
			String classes) {
		super();
		this.id = id;
		this.name = name;
		this.week = week;
		this.day = day;
		this.time = time;
		this.lesson = lesson;
		this.place = place;
		this.teacher = teacher;
		this.classesid = classesid;
		this.termid = termid;
		this.teacherid = teacherid;
		this.coursesid = coursesid;
		this.electiveid = electiveid;
		this.classes = classes;
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
		this.name = name;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
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
		this.time = time;
	}

	public Integer getLesson() {
		return lesson;
	}

	public void setLesson(Integer lesson) {
		this.lesson = lesson;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
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

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", name=" + name + ", week=" + week + ", day=" + day + ", time=" + time
				+ ", lesson=" + lesson + ", place=" + place + ", teacher=" + teacher + ", classesid=" + classesid
				+ ", termid=" + termid + ", teacherid=" + teacherid + ", coursesid=" + coursesid + ", electiveid="
				+ electiveid + ", classes=" + classes + "]";
	}

}
