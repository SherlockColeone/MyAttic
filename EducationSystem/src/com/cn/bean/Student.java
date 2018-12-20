package com.cn.bean;

/**
 * 	学生类
 * @author Sherlock
 *
 */
public class Student {
	//学生学号
	private Integer id;
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
	private Integer academyid;
	//专业编号
	private Integer majorid;
	//班级编号
	private Integer classesid;
	//身份
	private Integer identity;

    public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String regist, Integer academyid, Integer majorid, Integer classesid,
			Integer identity) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    public String getRegist() {
        return regist;
    }

    public void setRegist(String regist) {
        this.regist = regist == null ? null : regist.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", idcard=" + idcard
				+ ", birth=" + birth + ", password=" + password + ", address=" + address + ", birthplace=" + birthplace
				+ ", regist=" + regist + ", academyid=" + academyid + ", majorid=" + majorid + ", classesid="
				+ classesid + ", identity=" + identity + "]";
	}
}