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
#divPage {background-color: #C4E1E2;}
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
			msg = "해당 게시물의 댓글도 모두 삭제됩니다. 게시물을 삭제하시겠습니까?";
 			if(confirm(msg)!=0) { // yes 클릭
				location.href="/bbs/delete?reqPage=${param.reqPage}&bnum=${view.BNum}";
			} 
		});
		
	 	$("#replyViewBtn").click(function() {
	 		$("#replyViewPage").toggle();
	 	});
	}); 
</script>

</head>
<body>
<jsp:include page="../navbar.jsp" />
	
<div class="container">
  <form action="/bbs/modify">
<%--   <input type="hidden" name="reqPage" value="${recordCriteria.reqPage}"/> --%>

  <div id='viewMode'>
	  <div class="float-right">
		  <a href="/bbs/replyForm?reqPage=${param.reqPage}&bnum=${view.BNum}" class="btn btn-dark btn-sm">답글</a>
		  <a href="/bbs/list?reqPage=${param.reqPage}" class="btn btn-dark btn active btn-sm" role="button" aria-pressed="true">목록</a>
		  <C:if test="${user.username eq view.BID}">
			  <button id="modify" type="button" class="btn btn-outline-dark btn-sm">수정</button>
			  <button id="delete" type="button" class="btn btn-outline-dark btn-sm">삭제</button>
		  </C:if>
	  </div>
  
	  <br><br>
	  
		<div class="row">
	      <div class="col-md-12">
	        <div class="card">
	          <div class="card-header"><h3> ${view.BTitle} </h3> ${view.BName} <span style="text-align:right">${view.BCDate}</span></div>
				<div class="card-body">
					<!-- <h4>Card title</h4>
	              <h6 class="text-muted" >Subtitle</h6> -->
					<p>${view.BContent}</p>
					
					<br></br><hr />
					<button id="replyViewBtn" class="btn btn-outline-info btn-sm" type="button">댓글</button>
	      		</div>
	   	    </div>
	  	 </div>
	  </div>
	  
  </div>
  
  <div id='modifyMode' style="display: none;">
	  <input type="hidden" name="bNum" value="${view.BNum}" />
	  <input type="hidden" name="bGroup" value="${view.BGroup}" />
	  <input type="hidden" name="bStep" value="${view.BStep}" />
	  <input type="hidden" name="bIndent" value="${view.BIndent}" />
	  
	  <div class="float-right">
	  	  <C:if test="${user.username eq view.BID}">
		  <input id="submit" class="btn btn-dark btn-sm" type="submit" value="완료">
		  <button id="cancel" type="button" class="btn btn-secondary btn-sm">취소</button>
		  </C:if>
	      <a href="/bbs/list?reqPage=${param.reqPage}" class="btn btn-primary btn active btn-sm" role="button" aria-pressed="true">목록</a>
      </div>

	  <br><br>

	<div class="row">
      <div class="col-md-12">
        <div class="card">
          <div class="card-header">
            <input id="write" type="text" readonly="readonly" class="form-control" name="bTitle" value="${view.BTitle}">
            ${view.BName} <span style="text-align:right">${view.BCDate}</span></div>
			<div class="card-body">
				<!-- <h4>Card title</h4>
              <h6 class="text-muted" >Subtitle</h6> -->
			<input id="write" type="text" readonly="readonly" class="form-control" name="bContent" value="${view.BContent}">
      		</div>
   	   </div>
  	 </div>
   </div>
  </div>
</form>
</div>

<br></br>

<!-- 댓글 페이지 -->
<div id="replyViewPage" style="display: none;">
<jsp:include page="reply.jsp" />
</div>
</body>
</html>