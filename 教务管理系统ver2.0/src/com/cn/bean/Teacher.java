package com.cn.bean;
/**
 * ��ʦ��
 * @author Sherlock
 *
 */
public class Teacher {
	//��ʦ����
	private int id;
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
	//��ְ����
	private String entrytime;
	//ְλ
	private String position;
	//����ѧԺ���
	private int academyid;
	//���
	private int identity;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int id, String name, String sex, String phone, String idcard, String birth, String password,
			String address, String birthplace, String entrytime, String position, int academyid, int identity) {
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
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAcademyid() {
		return academyid;
	}
	public void setAcademyid(int academyid) {
		this.academyid = academyid;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	
}
