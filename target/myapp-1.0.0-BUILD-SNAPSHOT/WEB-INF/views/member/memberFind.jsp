<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />

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

		<form action="/member/memberFindID" method="post">
            <h5 class="center">Find ID</h5>

            <div class="input-field">
              <label for="name">
                Name
              </label>
              	<input name="name" id="name" type="text" class="validate" />
            </div>

            <div class="input-field">
              <label for="birth">
                Birth
              </label>
              	<input name="birth" id="birth" type="text" class="validate" />
            </div>

            <div class="input-field">
              <label for="phone">
                Phone
              </label>
				<input name="phone" id="phone" type="text" class="validate" />
            </div>
            
            <p>
	            <button class="waves-effect waves-light btn" type="submit">아이디 찾기</button>
	            <a class="waves-effect waves-light btn" id="joinCancelBtn" href="/login/loginIn">취소</a>
			</p>
       </form>
    </div>
   </div>
  </div>
 </div>
</div>

 <div class="section container">
  <div class="row">
    <div class="col s12 m6 offset-m3">
      <div class="card login-wrapper">
        <div class="card-content">
       <form action="/member/memberFindPawd" method="post">
            <h5 class="center">Find Password</h5>
       
            <div class="input-field">
              <label for="id">
                ID
              </label>
				<input name="id" id="id" type="text" class="validate" />
            </div>
            
            <div class="input-field">
              <label for="birth">
                Birth
              </label>
				<input name="birth" id="birth" type="text" class="validate" />
            </div>
            
            <div class="input-field">
              <label for="phone">
                Phone
              </label>
				<input name="phone" id="phone" type="text" class="validate" />
            </div>
	
			<p>
	            <button class="waves-effect waves-light btn" type="submit">비밀번호 찾기</button>
				<a class="waves-effect waves-light btn" href="/login/loginIn">취소</a>
			</p>
          </form>

        </div>
      </div>
    </div>
  </div>
</div>
</section>
</body>
</html>