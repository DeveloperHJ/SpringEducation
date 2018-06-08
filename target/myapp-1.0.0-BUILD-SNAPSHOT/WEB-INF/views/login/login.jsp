<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    

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
</head>
<body>
<jsp:include page="../navbar.jsp" />

<section style="margin-top: 10%">
 <div class="section container">
  <div class="row">
    <div class="col s12 m6 offset-m3">
      <div class="card login-wrapper">
        <div class="card-content">
        
		<form:form modelAttribute="login" action="/login/memLoginOK" method="post">
        
        <div class="input-field">
          <i class="material-icons prefix">person_outline</i>
          <form:input path="id" class="validate" />
          <label for="id">Your email</label>
        </div>
      
        <div class="input-field">
          <i class="material-icons prefix">lock_outline</i>
          <form:password path="passwd" class="validate" />
          <label for="passwd">Your password</label>
        </div>
	     
	    <div>
		<button class="btn waves-effect waves-light" type="submit" name="action" id="loginBtn">
	   	  <i class="material-icons right">send</i> Login
	    </button>
	    </div>
	    
		<p style="text-align:right">
		  Not a member? <a id="joinBtn" href="/member/memberJoin">Sign in</a><br>
		  Not remember? 
		  <a id="joinBtn" href="../member/memberFind">Find ID/Password</a> 
		</p>
		
		</form:form>
		</div>
 	  </div>
  	</div>
  </div>
 </div>
</section>
</body>
</html>