<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" scope="session" />

<!DOCTYPE html> 
<html>
<head>

<jsp:include page="../header.jsp" />

<title>Insert title here</title>

<!-- 유효성 검사를 위한 jquery -->
<script>
$(function() {		
/* 	$("#joinBtn").on("click",function(e){
		e.preventDefault();		
		$(location).attr("href", $(this).attr("data-url"));
		location.href="/member/memberJoin";
	});		 */
	
	$("#loginBtn").on("click",function(e){
		e.preventDefault();		
		$("form").submit();
	});
});
</script>

<style>
	.errmsg {color: red;}
</style>
</head>

<body>
<jsp:include page="../navbar.jsp" />

<section style="margin-top: 4%">
  <div class="py-5">
    <div class="container">
      <div class="row" >
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-4 display-3">Spring Framework</h1>
          <p class="mb-5 lead">Kim Hyeonjeong</p>
        </div>
        <div class="col-lg-5 p-3">
       	<c:url value="login" var="loginUrl" />
       	<c:if test="${param.fail != null }">
        		<b>로그인 실패</b>
       	</c:if>
       	<form:form class="p-4 bg-dark-opaque" action="${pageContext.request.contextPath}/${loginUrl}" method="post">
            <div class="form-group">
              <label>Email</label>
				<input type="text" id="username" name="username" class="form-control" />
				<form:errors path="username" cssClass="errmsg" />
            </div>
            <div class="form-group">
              <label>Password</label>
				<input type="password" id="password" name="password" class="form-control" />
				<form:errors path="password" cssClass="errmsg" />
            </div>
            <button type="submit" name="action" id="loginBtn" class="btn mt-4 btn-block btn-outline-primary p-2">
              <b>Login</b>
            </button>
            <br>
            <p style="text-align:right">
			  Not a member? <a id="joinBtn" href="/member/memberJoin">Sign in</a><br>
			  Not remember? 
			  <a id="joinBtn" href="/member/memberFind">Find ID/Password</a> 
			</p>
        </form:form>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>