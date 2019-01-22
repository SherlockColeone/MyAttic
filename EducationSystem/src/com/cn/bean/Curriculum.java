package com.cn.bean;

/**
 * �ܿγ���
 * ��;����ʵ�������רҵ�μ�ѡ�޿Σ�Ҳ�����ڷ�������ʵ�������ԣ���Ϊһ�����ݵ�����
 * ע�⣺���������ݿ����࣬����Ϊʵ����
 * @author Sherlock
 *
 */
public class Curriculum {
	//�γ�id��רҵ�ξ���רҵ��id��ѡ�޿ξ���ѡ�޿�id��
	private Integer id;
	//�γ�����
	private String name;
	//�Ͽ��ܴ�
	private String week;
	//����
	private Integer day;
	//�Ͽν���
	private String time;
	//�γ̴��
	private Integer lesson;
	//�Ͽεص�
	private String place;
	//�ο���ʦ
	private String teacher;
	//�༶id
	private Integer classesid;
	//ѧ��id
	private Integer termid;	
	//�ο���ʦid
	private Integer teacherid;
	//רҵ��id����Ϊ0��˵���ÿγ̲���רҵ��
	private Integer coursesid;
	//ѡ�޿�id����Ϊ0��˵���ÿγ̲���ѡ�޿�
	private Integer electiveid;
	//�༶����
	private String classes;
	
	public Curriculum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//��ʾѧ����������İ༶��������ѧ��
	public Curriculum(Integer id, String name, String classes) {
		super();
		this.id = id;
		this.name = name;
		this.classes = classes;
	}

	//ѡ�޿������ѡ�޿�id
	public Curriculum(String name, String time, String place, Integer electiveid) {
		super();
		this.name = name;
		this.time = time;
		this.place = place;
		this.electiveid = electiveid;
	}
	
	//רҵ�������רҵ��id�Ͱ༶����
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
	
	//��������
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
