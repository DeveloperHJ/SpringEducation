package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class LoginVO {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="이메일 형식이 아닙니다.")
	private String id;			//회원아이디(이메일)
	
	@Size(min=4, max=30, message="비밀번호는 4~30자리로 입력해주세요.")
	private String passwd;	//비밀번호
	
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

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", passwd=" + passwd + "]";
	}
}
