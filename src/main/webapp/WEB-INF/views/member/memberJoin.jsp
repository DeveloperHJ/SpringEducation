<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="http://www.clubdesign.at/floatlabels.js"></script>

<!-- 유효성 검사 jquery -->
<!-- 
<script src="/Webedu/public/jquery/jquery-3.3.1.js"></script>
<script>
	$(function() {
		$("form").submit(function() {
			if($("#id").val() == "") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if($("#id").val().length < 4) {
				alert("아이디는 최소 4글자 이상이어야 합니다.");
				$("#id").focus();
				return false;
			} else if($("#passwd").val() == "") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			} else if($("#passwd").val() != $("#passwd_check").val()) {
				alert("비밀번호가 일치하지 않습니다!");
				$("#passwd").focus();
				return false;
			} 
		});
	});
</script>
 -->
</head>
<body>
<!-- 입력할 때 보기쉬우라고 sql에서 복사해옴
ID	VARCHAR2(30 BYTE)	No		1	회원아이디(이메일)
PASSWD	VARCHAR2(30 BYTE)	No		2	비밀번호
NAME	VARCHAR2(20 BYTE)	No		3	이름
BIRTH	CHAR(8 BYTE)	No		4	생년월일
PHONE	VARCHAR2(11 BYTE)	No		5	휴대폰번호
CBD_1	VARCHAR2(20 BYTE)	Yes		6	예약1
CBD_2	VARCHAR2(20 BYTE)	Yes		7	
CBD_3	VARCHAR2(20 BYTE)	Yes		8	
CBD_4	VARCHAR2(20 BYTE)	Yes		9	
CBD_5	VARCHAR2(20 BYTE)	Yes		10	
CDATE	DATE	No	SYSDATE 	11	생성일
UDATE	DATE	No	SYSDATE 	12	수정일 
-->
<div class="container">
	<div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
		    		<h3 class="panel-title">Member Join에 오신 것을 환영합니다. </h3>
		 			</div>
		 			<div class="panel-body">
		    		<form role="form">
		    			<div class="form-group">
							<input type="email" name="email" id="email" class="form-control input-sm" placeholder="이메일 주소(ID로 사용)">
		    			</div>
		    			
		    			<div class="row">
		    				<div class="col-xs-6 col-sm-6 col-md-6">
		    					<div class="form-group">
		    						<input type="password" name="password" id="password" class="form-control input-sm" placeholder="비밀번호">
		    					</div>
		    				</div>
		    				<div class="col-xs-6 col-sm-6 col-md-6">
		    					<div class="form-group">
		    						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="비밀번호 확인">
		    					</div>
		    				</div>
		    			</div>
		    			
		    			<div class="form-group">
							<input type="email" name="email" id="email" class="form-control input-sm" placeholder="이름">
		    			</div>
		    			
		    			<div class="form-group">
							<input type="email" name="email" id="email" class="form-control input-sm" placeholder="생년월일 ex) 20130521">
		    			</div>
		    			
		    			<div class="form-group">
							<input type="email" name="email" id="email" class="form-control input-sm" placeholder="휴대폰 ex) 01012345678">
		    			</div>
			    			
		    			<input type="submit" value="Register" class="btn btn-info btn-block">
		    		</form>
		    	</div>
    		</div>
   		</div>
   	</div>
</div>
</body>
</html>