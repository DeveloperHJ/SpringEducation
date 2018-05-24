package com.kh.myapp.member.vo;

import java.sql.Date;

/*
ID	VARCHAR2(30 BYTE)	No		1	ȸ�����̵�(�̸���)
PASSWD	VARCHAR2(30 BYTE)	No		2	��й�ȣ
NAME	VARCHAR2(20 BYTE)	No		3	�̸�
BIRTH	CHAR(8 BYTE)	No		4	�������
PHONE	VARCHAR2(11 BYTE)	No		5	�޴�����ȣ
GENDER	CHAR(1 BYTE)	No		6	����
CDATE	DATE	No	SYSDATE 	7	������
UDATE	DATE	No	SYSDATE 	8	������
*/

/**
 * USER: SPRING, TABLE: MEMBER
 * VO: ���� DTO��� ���� ��. 
 */
public class MemberVO {
	private String id;			//ȸ�����̵�(�̸���)
	private String passwd;	//��й�ȣ
	private String name;		//�̸�
	private String birth;		//�������
	private String phone; 	//��ȭ��ȣ
	private String gender;	//����('W':��, 'M':��)
	private Date cdate;			//������
	private Date udate;			//������
	
	public MemberVO() { }
	
	public MemberVO(String id, String passwd, String name, String birth, String phone, String gender) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", birth=" + birth + ", phone=" + phone
				+ ", gender=" + gender + ", cdate=" + cdate + ", udate=" + udate + "]";
	}
}