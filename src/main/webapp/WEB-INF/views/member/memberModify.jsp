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
	
	$("#modifyBtn").on("click",function(e){
		e.preventDefault();
		
		$("form").submit();
	});
		
	$("#modifyNoBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/";
	});		
});
</script>
<style>
	.errmsg {color: red;}
</style>
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="memberVO" action="/member/memberModifyOK" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td>
		<form:input path="id" type="text" readonly="true" />
		<form:errors path="id" type="text" cssClass="errmsg" />
		<!-- memberVO에서 지정해준 유효성 검사 에러 이렇게 뜸 -->
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
		<form:input path="passwd" type="text" />
		<form:errors path="passwd" type="text" cssClass="errmsg" />
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
			<button id="modifyBtn">수정</button>
			<button id="modifyNoBtn">취소</button>
	</tr>	
</table>
</form:form>
</body>
</html>