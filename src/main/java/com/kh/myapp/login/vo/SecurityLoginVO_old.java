package com.kh.myapp.login.vo;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SecurityLoginVO_old {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="�̸��� ������ �ƴմϴ�.")
	private String username;			//ȸ�����̵�(�̸���)
	
	@Size(min=4, max=30, message="��й�ȣ�� 4~30�ڸ��� �Է����ּ���.")
	private String password;	//��й�ȣ
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginVO [username=" + username + ", password=" + password + "]";
	}
}
