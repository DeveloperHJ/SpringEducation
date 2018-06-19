<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" scope="session" />

<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
  
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/Webedu/public/bootstrap/dist/css/bootstrap.css">
  <script src="/Webedu/public/jquery/jquery.js"></script>
  <script src="/Webedu/public/bootstrap/dist/js/bootstrap.js"></script> -->
<title>Insert title here</title>
<style>
div.table { width: 100% }
th { width: 100px }
</style>
<jsp:include page="../header.jsp" />

</head>
<body>
<jsp:include page="../navbar.jsp" />

<div class="container">
  <br />
  <h2 style="text-align: center"> 글쓰기 </h2> <br></br>
  <form action="/bbs/write" method="post">
  <sec:csrfInput /> <!-- 스프링 폼 태그에는 포함돼있어서 따로 쓰지 않아도 됨. -->
  	<input type="hidden" name="reqPage" value="${param.reqPage}" />	<!-- 글쓴 뒤 페이지 유지 -->
  	<input type="hidden" name="bID" value="${user.username}" />	<!-- 글쓴 뒤 페이지 유지 -->
  		<table class="table table-hover">
			<tr>
				<th class = "th-dark" scope="col">작성자</th>
				<td><input type="text" class="form-control" name="bName" placeholder="이름을 입력하세요." value="${user.name}" readOnly="true"></td>
			</tr>
			<tr>
				<th class = "th-dark" scope="col">제목</th>
				<td><input type="text" class="form-control" name="bTitle" placeholder="제목을 입력하세요."></td>
			</tr>
			<tr>
				<th class = "th-dark" scope="col">내용</th>
				<td><textarea class="form-control" name="bContent" placeholder="내용을 입력하세요." rows="5"></textarea></td>
			</tr>
		</table>
		
		<div style="text-align: right">
		<input class="btn btn-primary" type="submit" value="등록">
		<a href="/bbs/list" class="btn btn-secondary" role="button" aria-pressed="true">취소</a>
		</div>
	</form>
</div>
</body>
</html>