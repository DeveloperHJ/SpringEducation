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
			$(this).focus();비
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
  <div class="py-5" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/form_red.jpg&quot;);">
    <div class="container">
      <div class="row">
        <div class="align-self-center col-md-6 text-white">
          <h1 class="text-center text-md-left display-3">Book a table</h1>
          <p class="lead">Why waiting if you can do it online?</p>
        </div>
        <div class="col-md-6">
          <div class="card">
            <div class="card-body p-5">
              <h3 class="pb-3">Make a reservation</h3>
              <form:form modelAttribute="memberVO" action="/member/memberJoinOK" method="post">
              <h4 class="center">Create Account</h4>
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
                  <form:input path="name" class="form-control" placeholder="Your phone, please"/>
				  <form:errors path="name" cssClass="errmsg" />
				</div>
                <div class="form-group">
                  <label>gender</label>
                  <form:radiobutton path="gender" value="W" /><span>여</span>
                  <form:radiobutton path="gender" value="M" /><span>남</span>
                  <form:errors path="gender" cssClass="errmsg" />
                </div>
        		<p>
		            <button class="btn mt-2 btn-outline-dark" id="joinBtn">가입</button>
					<button class="btn mt-2 btn-outline-dark" id="joinCancelBtn">취소</button>
					<button class="btn mt-2 btn-outline-dark" id="joinClearBtn">초기화</button>
				</p>
              </form:form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>