<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="../header.jsp" flush="true"></jsp:include>

<script>
$(function(){
	$("input[name=password]").keyup(function(e) {
		e.preventDefault();
		if($("input[name=password]").val() != $("input[name=passwd]").val()) {
			$("#passwordErr").text('비밀번호가 일치하지 않습니다.');
			$(this).focus();비
		} else {
			$("#passwordErr").text('');
		}
	});
	
	$("#joinBtn").on("click",function(e){
		e.preventDefault();
		
		$("form").submit();
	});
	
	$("#joinClearBtn").on("click",function(e){
		e.preventDefault();		
		  $("form").each(function(){
			    this.reset();
		 });
	});	
	
	$("#joinCancelBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/member/memberList";
	});		
});
</script>
<style>
	.errmsg {color: red;}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../navbar.jsp" flush="true"></jsp:include>

<div class="container">
<form:form modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td>
		<form:input path="id" />
		<form:errors path="id" cssClass="errmsg" />
		<!-- memberVO에서 지정해준 유효성 검사 에러 이렇게 뜸 -->
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
		<th>비밀번호확인</th>
		<td>
		<input type="password" name="password" />
		<span id="passwordErr" class="errmsg"></span>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>
		<form:input path="name" type="text" />
		<form:errors path="name" type="text" cssClass="errmsg" />
		</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>
		<form:input path="birth" type="text" />
		<form:errors path="birth" type="text" cssClass="errmsg" />
		</td>
	</tr>
	<tr>
		<th>전화번호</th> 
		<td>
		<form:input path="phone" type="text" />
		<form:errors path="phone" type="text" cssClass="errmsg" />
		</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
		여<form:radiobutton path="gender" value="W" />
		남<form:radiobutton path="gender" value="M" />
		<form:errors path="gender" cssClass="errmsg" />
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<button id="joinBtn">가입</button>
			<button id="joinClearBtn">초기화</button>
			<button id="joinCancelBtn">가입취소</button>
	</tr>	
</table>
</form:form>
</div>
</body>
</html>