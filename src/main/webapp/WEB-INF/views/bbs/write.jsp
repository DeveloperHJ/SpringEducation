<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" scope="session" />

<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
  
<!DOCTYPE html>
<html>
<head>
<title>글쓰기</title>

<style>
div.table { width: 100% }
th { width: 100px }
.errmsg {color: red;}

</style>

<jsp:include page="../header.jsp" />

</head>
<body>
<jsp:include page="../navbar.jsp" />
<div class="container">
  <br />
  <h2 style="text-align: center"> 글쓰기 </h2> <br></br>
  <form:form modelAttribute="bbsdto" action="/bbs/writeOK" method="post">
  	<%-- <form:hidden path="reqPage" value="${param.reqPage}" />	<!-- 글쓴 뒤 페이지 유지 --> --%>
  	<input type="hidden" name="bID" value="${user.username}" />	<!-- 글쓴 뒤 페이지 유지 -->
  			<div class="form-group">
                  <label>작성자</label>
                  <input class="form-control" name="bName" placeholder="이름을 입력하세요." 
						   		value="${user.name}" readOnly="readOnly" />
            </div>
            <div class="form-group">
                  <label>제목</label>
                  <input class="form-control" name="bTitle" placeholder="제목을 입력하세요." />
				  <form:errors path="bTitle" cssClass="errmsg" />
			</div>
            <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" name="bContent" placeholder="내용을 입력하세요." rows="5"></textarea>
				  <form:errors path="bContent" cssClass="errmsg" />
			</div>
  		<%-- <table class="table table-hover">
			<tr>
				<th class = "th-dark" scope="col">작성자</th>
				<td><input class="form-control" name="bName" placeholder="이름을 입력하세요." 
						   		value="${user.name}" readOnly="readOnly" /></td>
			</tr>
			<tr>
				<th class = "th-dark" scope="col">제목</th>
				<td><input class="form-control" name="bTitle" placeholder="제목을 입력하세요." /></td>
				<form:errors path="bTitle" cssClass="errmsg" />
			</tr>
			<tr>
				<th class = "th-dark" scope="col">내용</th>
				<td><textarea class="form-control" name="bContent" placeholder="내용을 입력하세요." rows="5"></textarea></td>
				<form:errors path="bTitle" cssClass="errmsg" />
			</tr>
		</table> --%>
		
		<div style="text-align: right">
		<input class="btn btn-primary" type="submit" value="등록">
		<a href="/bbs/list" class="btn btn-secondary" role="button" aria-pressed="true">취소</a>
		</div>
	</form:form>
</div>
</body>
</html>