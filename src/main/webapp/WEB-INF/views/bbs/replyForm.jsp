<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />

<title>Insert title here</title>
<script>
$(function() {		// = JQuery(function() {
	$("form").submit(function() {
		if($("#inputName").val() == "") {
			alert("작성자 이름을 입력해주세요!");
			$("#inputName").focus();
			return false;
		} 
	});
});
</script>
<style>
th { width: 100px }
</style>
</head>

<body>
<jsp:include page="../navbar.jsp" />

<div class="container">
  <br></br>
  <form method="post" action="/bbs/reply">
  <input type="hidden" name="BNum" value="${bNum}" />
  <%-- <input type="hidden" name="reqPage" value="${recordCriteria.reqPage}"/> --%>
  
  <h2 style="text-align: center"> 답글 작성하기 </h2> <br></br> 
	
  <br />
 	<table class="table table-hover">
		<tr>
			<th class="th-dark" scope="col">작성자</th>
			<td><input id="inputName" type="text" class="form-control" name="BName" placeholder="이름을 입력하세요."></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">제목</th>
			<td><input id="write" type="text" class="form-control" name="BTitle"></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">내용</th>
			<td><textarea class="form-control" name="BContent" rows="5"></textarea></td>
		</tr>
	</table> 
	<div style="text-align: right">
	<input class="btn btn-primary" type="submit" value="답글 등록">
	<a href="/bbs/list/reqPage=${recordCriteria.reqPage}" class="btn btn-secondary" role="button" aria-pressed="true">취소</a>
	</div>
  	</form>
</div>
</body>
</html>