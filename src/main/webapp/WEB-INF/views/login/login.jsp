<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/public/jquery/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
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
<form:form modelAttribute="login" action="/login/memLoginOK" method="post">
<!--   <div class="row" style="position: absolute; left: 50%; transform: translateX(-50%);
  					 	  border:1px; "> -->
  <div class="center-align">
  <div class="row">
    <div class="col s12">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">person_outline</i>
          <form:input path="id" class="validate" />
          <label for="id">Your email</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">lock_outline</i>
          <form:password path="passwd" class="validate" />
          <label for="passwd">Your password</label>
        </div>
      </div>
    </div>
    <div class="row">
    <div class="input-field col s12">
	 <button class="btn waves-effect waves-light" type="submit" name="action" id="loginBtn">
	 	<i class="material-icons right">send</i> Login
	 </button>
	 
	 <span style="float: right">
		Not a member? <a id="joinBtn" href="/member/memberJoin">Sign in</a>
	 </span>
	 </div>
	 </div>
  </div>
  </div>
</form:form>

</body>
</html>