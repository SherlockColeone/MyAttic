package com.cn.bean;

/**
 * 	教师类
 * @author Sherlock
 *
 */
public class Teacher {
	//教师工号
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
	//入职日期
	private String entrytime;
	//职位
	private String position;
	//二级学院编号
	private Integer academyid;
	//身份
	private Integer identity;

    public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String entrytime, String position, Integer academyid, Integer identity) {
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
		this.entrytime = entrytime;
		this.position = position;
		this.academyid = academyid;
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

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime == null ? null : entrytime.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", idcard=" + idcard
				+ ", birth=" + birth + ", password=" + password + ", address=" + address + ", birthplace=" + birthplace
				+ ", entrytime=" + entrytime + ", position=" + position + ", academyid=" + academyid + ", identity="
				+ identity + "]";
	}
}