package com.kh.myapp.login.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.loader.plan.build.spi.MetamodelDrivenLoadPlanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kh.myapp.login.vo.SecurityLoginVO;
import com.kh.myapp.member.vo.MemberVO;

public class LoginDAOImplSecurity implements UserDetailsService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 1) 사용자 정보 가져오기
		MemberVO memberVO;
		StringBuffer str = new StringBuffer();
		
		str.append("select id, passwd, name, birth, phone, gender, cdate, udate from member where id = ?");
		
		memberVO = (MemberVO)this.jdbcTemplate.queryForObject(str.toString(), 
							new Object[] {username}, new BeanPropertyRowMapper<>(MemberVO.class));
		
		if(memberVO == null) { // 사용자가 존재하지 않는 경우 
			throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
		}
		
		// 2) 사용자 권한 정보 가져오기 
		List<String> auth = new ArrayList<>();
		StringBuffer str2 = new StringBuffer();
		str2.append("select role from user_role where id = ?");
		
		auth = (ArrayList<String>) this.jdbcTemplate.queryForList(str2.toString(), 
						new Object[] {username}, String.class);
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (String role : auth) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
			
		SecurityLoginVO loginVO = new SecurityLoginVO(memberVO.getId(), memberVO.getPasswd(), authorities);
		loginVO.setName(memberVO.getName());
		loginVO.setBirth(memberVO.getBirth());
		loginVO.setPhone(memberVO.getPhone());
		loginVO.setGender(memberVO.getGender());
		
		
		return loginVO;
	}
	
}
