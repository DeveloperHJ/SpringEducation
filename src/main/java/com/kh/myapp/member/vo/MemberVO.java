package com.kh.myapp.member.vo;

import java.sql.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

/*
ID	VARCHAR2(30 BYTE)	No		1	회원아이디(이메일)
PASSWD	VARCHAR2(30 BYTE)	No		2	비밀번호
NAME	VARCHAR2(20 BYTE)	No		3	이름
BIRTH	CHAR(8 BYTE)	No		4	생년월일
PHONE	VARCHAR2(11 BYTE)	No		5	휴대폰번호
GENDER	CHAR(1 BYTE)	No		6	성별
CDATE	DATE	No	SYSDATE 	7	생성일
UDATE	DATE	No	SYSDATE 	8	수정일
*/

/**
 * USER: SPRING, TABLE: MEMBER
 * VO: 기존 DTO라고 보면 됨. 
 */
public class MemberVO {
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="이메일 형식이 아닙니다.")
	private String id;			//회원아이디(이메일)
	
	@Size(min=4, max=30, message="비밀번호는 4~30자리로 입력해주세요.")
	private String passwd;	//비밀번호
	
	@Size(min=4, max=20, message="이름은 4~20자리로 입력해주세요.")
	private String name;		//이름
	
	@NotNull
	private String birth;		//생년월일
	
	@NotNull
	private String phone; 	//전화번호
	
	@NotNull
	private String gender;	//성별('W':여, 'M':남)
	private Date cdate;			//생성일
	private Date udate;			//수정일
	
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
