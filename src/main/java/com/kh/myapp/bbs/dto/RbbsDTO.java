package com.kh.myapp.bbs.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Data // getter, setter, toString, equals, hashCode �ڵ�����
@NoArgsConstructor // ����Ʈ ������ 
@AllArgsConstructor
@Slf4j	// �α� ������� ���� log
public class RbbsDTO {
	private int rnum;					// ��۹�ȣ 
	private int bnum;					// ���۹�ȣ 
	private String rid;				// �ۼ���ID
	private String rname;			// �ۼ����̸�
	private Date rcdate; 			// �ۼ��Ͻ� 
	private Date rudate; 			// �����Ͻ� 
	private String rcontent;	// ��۳���
	private int rgood;				// ���ƿ�
	private int rbad; 				// ����
	private int rgroup; 			// ��۱׷�
	private int rstep; 				// ��۴ܰ�
	private int rindent; 			// ��� �鿩���� 
}
