<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../header.jsp" />

<title>Insert title here</title>
<style>
th { width: 100px }
</style>

<script>
 	$(function() {
		$("button#modify").click(function() {
			$("input#write").attr("readonly", false);
			$("div#viewMode").hide();
			$("div#modifyMode").show();
		});
		
		$("#cancel, #submit").click(function() {
			$("input#write").attr("readonly", true);
			$("div#modifyMode").hide();
			$("div#viewMode").show();
		});
		
		$("#delete").click(function() {
			msg = "게시물을 삭제하시겠습니까?";
 			if(confirm(msg)!=0) { // yes 클릭
				location.href="/bbs/delete?reqPage=${param.reqPage}&bnum=${view.BNum}";
			} 
		});
	}); 

</script>

</head>
<body>
<jsp:include page="../navbar.jsp" />
	
<div class="container">
  <br></br>
  <form action="/bbs/modify">
<%--   <input type="hidden" name="reqPage" value="${recordCriteria.reqPage}"/> --%>

  <div id='viewMode' style="text-align: right">
  <a href="/bbs/list?reqPage=${param.reqPage}" class="btn btn-primary btn active" role="button" aria-pressed="true">목록</a>
  <C:if test="${user.username eq view.BID}">
  <button id="modify" type="button" class="btn btn-primary">수정</button>
  <button id="delete" type="button" class="btn btn-primary">삭제</button>
  </C:if>
  </div>
  
  <div id='modifyMode' style="text-align: right; display: none;">
  <input type="hidden" name="bNum" value="${view.BNum}" />
  <input type="hidden" name="bGroup" value="${view.BGroup}" />
  <input type="hidden" name="bStep" value="${view.BStep}" />
  <input type="hidden" name="bIndent" value="${view.BIndent}" />
  <input id="submit" class="btn btn-primary" type="submit" value="완료">
  <button id="cancel" type="button" class="btn btn-secondary">취소</button>
  <a href="/bbs/list?reqPage=${param.reqPage}" class="btn btn-primary btn active" role="button" aria-pressed="true">목록</a>
  </div>
  
  <br />
 	<table class="table table-hover">
		<tr>
			<th class="th-dark" scope="col">작성자</th>
			<td><input type="text" readonly="readonly" class="form-control" name="bName" value="${view.BName}"></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">작성일</th>
			<td><input type="text" readonly="readonly" class="form-control" value="${view.BCDate}"></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">수정일</th>
			<td><input type="text" readonly="readonly" class="form-control" value="${view.BUDate}"></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">제목</th>
			<td><input id="write" type="text" readonly="readonly" class="form-control" name="bTitle" value="${view.BTitle}"></td>
		</tr>
		<tr>
			<th class="th-dark" scope="col">내용</th>
			<td><input id="write" type="text" readonly="readonly" class="form-control" name="bContent" value="${view.BContent}"></td>
		</tr>
	</table> 
	<p style="text-align: right"><a href="/bbs/replyForm?reqPage=${param.reqPage}&bnum=${view.BNum}" class="btn btn-primary">답글</a></p>
  	</form>
  	
  	<!-- 댓글 페이지 -->
	<jsp:include page="reply.jsp" />
</div>


</body>
</html>