<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>

<style>
* {margin:auto;text-align:center;}
html, body {margin:0; padding:0; height:100%}
#header {height:10%; background:#ffffff}
#nav {height:10%; background:#ECF4FE}
#content {height:70%; background:#ffffff}
#footer {height:10%; background:#f0f0f0}
</style>
</head>

<body>
<header id="header"></header>
<nav id="nav"></nav>
<section id="content">
${user.id}님 환영합니다. <br>
<a href="/login/loginIn">로그인</a><br>
<a href="/login/logOut">로그아웃</a><br>
<a href="/member/memberJoin">회원가입</a>
</section>
<footer id="footer"></footer>
</body>

</html>