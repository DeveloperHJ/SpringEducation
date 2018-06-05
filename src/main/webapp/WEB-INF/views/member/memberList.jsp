<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" flush="true"></jsp:include>

<title>회원목록</title>
<script>
$(function() {
	$("#modi, #del, #list").on("click", function() {
		$(location).attr('href', $(this).attr('data-url'));
	});
});
</script>
</head>
<body>
<jsp:include page="../navbar.jsp" flush="true"></jsp:include>
<div class="container" style="margin-top: 3%;">
회원목록
<ul class="collapsible">
<C:forEach items="${memberVOS}" var="memberVO">
  <li>
    <div class="collapsible-header">
    	<i class="material-icons" style="position: relative;">filter_drama</i>${memberVO.id}
    	&emsp;&emsp;
 		<a href=# id="modi" data-url="/member/memberModify/${memberVO.id}">수정</a>
		<a href=# id="del" data-url="/member/memberDelete/${memberVO.id}">삭제</a>
	</div>
    <div class="collapsible-body">
    	<span>
			이름: ${memberVO.name } <br>
			생년월일: ${memberVO.birth } <br>
			전화번호: ${memberVO.phone } <br>
			성별: 
			<C:if test="${memberVO.gender eq 'W'}">여자</C:if>
			<C:if test="${memberVO.gender eq 'M'}">남자</C:if> 
    	</span>
   	</div>
  </li>
</C:forEach>
</ul>
</div>
</body>
</html>