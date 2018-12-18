package com.cn.bean;
/**
 * 学生类
 * @author Sherlock
 *
 */
public class Student {
	//学生学号
	private int id;
	//姓名
	private String name;
	//性别
	private String sex;
	//联系方式
	private String phone;
	//身份证号
	private String idcard;
	//出生日期
	private String birth;
	//密码
	private String password;
	//家庭地址
	private String address;
	//籍贯
	private String birthplace;
	//入学时间
	private String regist;
	//二级学院编号
	private int academyid;
	//专业编号
	private int majorid;
	//班级编号
	private int classesid;
	//身份
	private int identity;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String regist, int academyid, int majorid, int classesid, int identity) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.idcard = idcard;
		this.birth = birth;
		this.password = password;
		this.address = address;
		this.birthplace = birthplace;
		this.regist = regist;
		this.academyid = academyid;
		this.majorid = majorid;
		this.classesid = classesid;
		this.identity = identity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getRegist() {
		return regist;
	}
	public void setRegist(String regist) {
		this.regist = regist;
	}
	public int getAcademyid() {
		return academyid;
	}
	public void setAcademyid(int academyid) {
		this.academyid = academyid;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public int getClassesid() {
		return classesid;
	}
	public void setClassesid(int classesid) {
		this.classesid = classesid;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
}
