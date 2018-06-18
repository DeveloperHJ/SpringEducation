package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data // getter, setter, toString, equals, hashCode 자동생성
@NoArgsConstructor // 디폴트 생성자 
@AllArgsConstructor
@Slf4j	// 로그 멤버변수 생성 log
public class BbsDTO {
	
	@NotNull
	private int bNum;					// 게시글 번호
	private String bTitle;		// 제목
	private String bID;				// 작성자 ID
	private String bName;			// 작성자 이름
	private Date bCDate; 			// 작성일시 
	private Date bUDate; 			// 수정일시 
	private int bHit; 				// 조회수 
	private String bContent;	// 글내용
	private int bGroup; 			// 답글 그룹
	private int bStep; 		// 답변글의 단계 
	private int bIndent; 	// 답변글 들여쓰기 
}
