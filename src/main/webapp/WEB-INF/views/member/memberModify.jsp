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
	
	$("#modifyBtn").on("click",function(e){
		e.preventDefault();
		
		$("form").submit();
	});
		
	$("#modifyNoBtn").on("click",function(e){
		e.preventDefault();		
			location.href="/";
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
 <div class="section container" style="margin-top: 3%;">
  <div class="row">
    <div class="col s12 m6 offset-m3">
      <div class="card login-wrapper">
        <div class="card-content">

		<form:form modelAttribute="memberVO" action="/member/memberModifyOK" method="post">
            <h4 class="center">Account Information</h4>

            <div class="input-field">
              <label for="id">
                Email
              </label>
              	<form:input path="id" readonly="true" />
				<form:errors path="id" cssClass="errmsg" />	
            </div>
            
            <div class="input-field">
              <label for="name" class="">
                Name
              </label>
              	<form:input path="name" />
				<form:errors path="name" cssClass="errmsg" />
            </div>

            <div class="input-field">
              <label for="passwd">
                Password
              </label>
				<form:password path="passwd" />
				<form:errors path="passwd" cssClass="errmsg" />
            </div>
            
            <div class="input-field">
              <label for="password">
                Check Password
              </label>
              	<input type="password" name="password" />
				<span id="passwordErr" class="errmsg"></span>
            </div>
            
            <div class="input-field">
              <label for="birth">
                Birth
              </label>
				<form:input path="birth" />
				<form:errors path="birth" cssClass="errmsg" />
            </div>
            
            <div class="input-field">
              <label for="phone">
                Phone
              </label>
				<form:input path="phone" />
				<form:errors path="phone" cssClass="errmsg" />
            </div>
            
              <label for="gender">
              	Gender
              </label>
              <p>
              <label>
				<form:radiobutton path="gender" value="W" /><span>여</span>
			  </label>
			  <label>
				<form:radiobutton path="gender" value="M" /><span>남</span>
			  </label>
			  <label>
				<form:errors path="gender" cssClass="errmsg" />
			  </label>
			  </p>
			
			<br />
			
			<p>
				<button class="waves-effect waves-light btn" id="modifyBtn">수정</button>
				<button class="waves-effect waves-light btn" id="modifyNoBtn">취소</button>
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