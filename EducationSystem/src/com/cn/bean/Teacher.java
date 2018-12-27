package com.cn.bean;

/**
 * 	��ʦ��
 * @author Sherlock
 *
 */
public class Teacher {
	//��ʦ����
	private Integer id;
	//����
	private String name;
	//�Ա�
	private String sex;
	//��ϵ��ʽ
	private String phone;
	//���֤��
	private String idcard;
	//��������
	private String birth;
	//����
	private String password;
	//��ͥ��ַ
	private String address;
	//����
	private String birthplace;
	//����
    private String nation;
    //������ò
    private String politics;
	//��ְ����
	private String entrytime;
	//ְλ
	private String position;
	//����ѧԺ���
	private Integer academyid;
	//���
	private Integer identity;
	//��Ƭ
    private String photo;

    public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String nation, String politics, String entrytime, String position,
			Integer academyid, Integer identity, String photo) {
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
		this.nation = nation;
		this.politics = politics;
		this.entrytime = entrytime;
		this.position = position;
		this.academyid = academyid;
		this.identity = identity;
		this.photo = photo;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics == null ? null : politics.trim();
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", idcard=" + idcard
				+ ", birth=" + birth + ", password=" + password + ", address=" + address + ", birthplace=" + birthplace
				+ ", nation=" + nation + ", politics=" + politics + ", entrytime=" + entrytime + ", position="
				+ position + ", academyid=" + academyid + ", identity=" + identity + ", photo=" + photo + "]";
	}
}