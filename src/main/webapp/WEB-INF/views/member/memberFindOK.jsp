<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../navbar.jsp" />

 <div class="section container">
  <div class="row">
    <div class="col s12 m6 offset-m3">
      <div class="card login-wrapper">
        <div class="card-content" style="text-align: center">
			<h5>찾으신 아이디/비밀번호는</h5>
			${id} ${passwd}입니다. 
			
			<br>	
			<p style="text-align: center">
			<a class="waves-effect waves-light btn" id="joinCancelBtn" href="/login/loginIn">로그인</a>
			<a class="waves-effect waves-light btn" id="joinCancelBtn" href="/">메인으로</a>
			</p>
		</div>
   	  </div>
    </div>
  </div>
</div>

</body>
</html>