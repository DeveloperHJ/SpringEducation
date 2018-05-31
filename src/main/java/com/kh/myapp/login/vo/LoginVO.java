package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class LoginVO {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="�̸��� ������ �ƴմϴ�.")
	private String id;			//ȸ�����̵�(�̸���)
	
	@Size(min=4, max=30, message="��й�ȣ�� 4~30�ڸ��� �Է����ּ���.")
	private String passwd;	//��й�ȣ
	
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
