<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />

 
<script>
$(function(){
	$("input[name=password]").keyup(function(e) {
		e.preventDefault();
		if($("input[name=password]").val() != $("input[name=passwd]").val()) {
			$("#passwordErr").text('비밀번호가 일치하지 않습니다.');
			$(this).focus();
		} else {
			$("#passwordErr").text('');
		}
	});
	
	$("#joinBtn").on("click",function(e){
		e.preventDefault();
		
		$("form").submit();
	});
	
	$("#joinClearBtn").on("click",function(e){
		e.preventDefault();		
		  $("form").each(function(){
			    this.reset();
		 });
	});	
	
	$("#joinCancelBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/member/memberList";
	});		
});
</script>
<style>
	.errmsg {color: red;}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../navbar.jsp" />

<section>
  <div class="py-5">
    <div class="container">
      <div class="row" >
        <div class="col-lg-7 align-self-center text-lg-left text-center">
          <h1 class="mb-0 mt-4 display-3">Spring Framework</h1>
          <p class="mb-5 lead">Kim Hyeonjeong</p>
        </div>
        <div class="col-lg-5 p-3">

       	<form:form class="p-4 bg-dark-opaque" modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
       		<h2>Create Account</h2>
           	<div class="form-group">
                  <label>Name</label>
                  <form:input path="name" class="form-control" placeholder="Your name, please"/>
				  <form:errors path="name" cssClass="errmsg" />
            </div>
            <div class="form-group">
                  <label>ID</label>
                  <form:input path="id" class="form-control" placeholder="Your id, please"/>
				  <form:errors path="id" cssClass="errmsg" />
			</div>
            <div class="form-group">
                  <label>Password</label>
                  <form:password path="passwd" class="form-control" placeholder="Your password, please"/>
				  <form:errors path="passwd" cssClass="errmsg" />
			</div>
            <div class="form-group">
                  <label>Check Password</label>
                  <input type="password" name="password" class="form-control" placeholder="Check password"/>
				  <span id="passwordErr" class="errmsg"></span>
			</div>
            <div class="form-group">
                  <label>birth</label>
                  <form:input path="birth" class="form-control" placeholder="Your birth, please"/>
				  <form:errors path="birth" cssClass="errmsg" />
			</div>
            <div class="form-group">
                  <label>phone</label>
                  <form:input path="phone" class="form-control" placeholder="Your phone, please"/>
				  <form:errors path="phone" cssClass="errmsg" />
			</div>
            <div class="form-group">
                  <label>gender</label><br>
                  <form:radiobutton path="gender" value="W" /><span>여</span>
                  <form:radiobutton path="gender" value="M" /><span>남</span>
                  <form:errors path="gender" cssClass="errmsg" />
            </div>
          	<button class="btn mt-4 btn-outline-primary p-2" id="joinBtn">가입</button>
			<button class="btn mt-4 btn-outline-primary p-2" id="joinCancelBtn">취소</button>
			<button class="btn mt-4 btn-outline-primary p-2" id="joinClearBtn">초기화</button>
        </form:form>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>