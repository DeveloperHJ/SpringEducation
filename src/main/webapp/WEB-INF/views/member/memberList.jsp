<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/Webedu/public/bootstrap/dist/css/bootstrap.min.css">
  <script src="/Webedu/public/jquery/jquery.min.js"></script>
  <script src="/Webedu/public/bootstrap/dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script>
$(function() {
	$("#modi, #del, #list").on("click", function() {
		$(location).attr('href', $(this).attr('data-url'));
	});
});
</script>
</head>
<body>
회원목록
<table border=1 cellpadding=0 cellspacing=0>
	<tr>
		<th>#</th>
		<th>아이디</th>
		<th>이름</th>
		<th>생년월일</th>
		<th>전화번호</th>
		<th>성별</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<C:forEach items="${memberVOS}" var="memberVO">
	<tr>
		<td>#</td>
		<td>${memberVO.id }</td>
		<td>${memberVO.name }</td>
		<td>${memberVO.birth }</td>
		<td>${memberVO.phone }</td>
		<td>
			<C:if test="${memberVO.gender eq 'W'}"> 여자 </C:if>
			<C:if test="${memberVO.gender eq 'M'}"> 남자 </C:if>
		</td>
		<td><button id="modi" data-url="/member/memberModify/${memberVO.id}">수정</button></td>
		<td><button id="del" data-url="/member/memberDelete/${memberVO.id}">삭제</button></td>
	</tr>
	</C:forEach>
	<tr>
		<td colspan="8" align="center">
			<button id="list" data-url="/member/memberJoin">회원가입</button>
		</td>
	</tr>
</table>
</body>
</html>