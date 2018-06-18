package com.kh.myapp.login.vo;

import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;


@Entity
@Data
public class SecurityLoginVO extends User {
	
	private String name;	//이름
	private String birth; //생년월일
	private String phone; //전화번호
	private String gender;  // 
	
	private static final long serialVersionUID = 1L;

	public SecurityLoginVO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
}
