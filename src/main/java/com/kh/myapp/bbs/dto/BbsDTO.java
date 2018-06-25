package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@Size(min=1, max=50, message="������ �ʹ� ª�ų� ��ϴ�.")
	private String bTitle;		// ����
	
	private String bID;				// �ۼ��� ID
	private String bName;			// �ۼ��� �̸�
	private Date bCDate; 			// �ۼ��Ͻ� 
	private Date bUDate; 			// �����Ͻ� 
	private int bHit; 				// ��ȸ�� 
	
	@Size(min=1, max=200, message="������ �ʹ� ª�ų� ��ϴ�.")
	private String bContent;	// �۳���
	
	private int bGroup; 			// ��� �׷�
	private int bStep; 		// �亯���� �ܰ� 
	private int bIndent; 	// �亯�� �鿩���� 
}
