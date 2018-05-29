<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
  <script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
  <script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
<!-- 유효성 검사를 위한 jquery -->
<script src="/Webedu/public/jquery/jquery-3.3.1.js"></script>
<script>
$(function() {		
	$("#join").on("click",function(e){
		e.preventDefault();		
		location.href="/member/memberJoin";
	});		
	
	$("#login").on("click",function(e){
		e.preventDefault();		
		$("form").submit();
	});		
	
/* 	$("form").submit(function() {
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
		} 
	}); */
});
</script>
</head>
<body>
<hr />
<h2>로그인</h2>
<hr />
<form:form modelAttribute="user" action="/login/memLoginOK.jsp" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td>
				<form:input path="id" />
				<form:errors path="id" cssClass="errmsg" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<form:input path="passwd" />
				<form:errors path="passwd" cssClass="errmsg" />
			</td>
		</tr>
		<tr>
			<td>
				<button id="login">로그인</button>
			</td>
			<td>
				<button id="join">회원가입</button>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>