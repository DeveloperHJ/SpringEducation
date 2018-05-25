<%@page import="com.edu.SqlResult"%>
<%@page import="com.edu.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id = "mdto" class= "com.edu.MemDTO"/> <!-- 단독태그는 끝에 / 붙이면 된다.. -->
<jsp:setProperty name = "mdto" property = "*"/>
<%
 
 String year = request.getParameter("year");
 String month = request.getParameter("month");
 String day = request.getParameter("day");
 mdto.setBirth(year+month+day);
 
%>

<C:set var="birth" value = "${param.year}${param.month}${param.day}" />

${mdto.getId()}
${mdto.getPasswd()}
${mdto.getName()}
${mdto.getBirth()}
${mdto.getPhone()}

<%
	MemberService mdao = MemberService.getInstance();
SqlResult sqlResult = mdao.checkId(mdto.getId());
%>

<C:choose>

<C:when test="${sqlResult == SqlResult.MEM_EXIST}"> 
	<script>
		window.alert ("아이디가 이미 존재합니다");
		window.History.back(); //뒤로 되돌아가기
	</script>
</C:when>

<C:when test="${sqlResult == SQlResult.MEM_NONEXIST}">
	<C:if test="${mdao.insertMember(mdto) == SqlResult.MEM_JOIN_SUCCESS}">
		<script>
			window.alert ("회원가입 처리 되었습니다");
			document.location.href = "login.jsp"; //로그인 화면으로 이동
		</script>
	</C:if>
	
	<C:otherwise>
		<script>
			window.alert ("회원가입에 실패하였습니다");
			document.location.href = "login.jsp";
		</script>
	</C:otherwise>
</C:when>

</C:choose>

</body>
</html>