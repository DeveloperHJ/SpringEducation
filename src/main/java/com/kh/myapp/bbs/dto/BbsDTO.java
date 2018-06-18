package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data // getter, setter, toString, equals, hashCode �ڵ�����
@NoArgsConstructor // ����Ʈ ������ 
@AllArgsConstructor
@Slf4j	// �α� ������� ���� log
public class BbsDTO {
	
	@NotNull
	private int bNum;					// �Խñ� ��ȣ
	private String bTitle;		// ����
	private String bID;				// �ۼ��� ID
	private String bName;			// �ۼ��� �̸�
	private Date bCDate; 			// �ۼ��Ͻ� 
	private Date bUDate; 			// �����Ͻ� 
	private int bHit; 				// ��ȸ�� 
	private String bContent;	// �۳���
	private int bGroup; 			// ��� �׷�
	private int bStep; 		// �亯���� �ܰ� 
	private int bIndent; 	// �亯�� �鿩���� 
}
