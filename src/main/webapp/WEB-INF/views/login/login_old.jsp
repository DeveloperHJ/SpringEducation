<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../header.jsp" flush="true"></jsp:include>

<title>Insert title here</title>
<!-- 유효성 검사를 위한 jquery -->

<script>
$(function() {		
	$("#joinBtn").on("click",function(e){
		e.preventDefault();		
		$(location).attr("href", $(this).attr("data-url"));
		location.href="/member/memberJoin";
	});		
	
	$("#loginBtn").on("click",function(e){
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
<jsp:include page="../navbar.jsp" flush="true"></jsp:include>
<div class="container">
<hr />
<h2>로그인</h2>
<hr />
<form:form modelAttribute="login" action="/login/memLoginOK" method="post">
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
				<form:password path="passwd" />
				<form:errors path="passwd" cssClass="errmsg" />
			</td>
		</tr>
		<tr>
			<td>
				<button id="loginBtn">로그인</button>
			</td>
			<td>
				<button id="joinBtn" data-url="/member/memberJoin">회원가입</button>
			</td>
		</tr>
	</table>
</form:form>
<div class="fa-3x">
  <i class="fas fa-spinner fa-spin"></i>
  <i class="fas fa-circle-notch fa-spin"></i>
  <i class="fas fa-sync fa-spin"></i>
  <i class="fas fa-cog fa-spin"></i>
  <i class="fas fa-spinner fa-pulse"></i>
</div>
</div>
</body>
</html>