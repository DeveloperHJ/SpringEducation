<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" scope="session" />

<div class="container-fluid">
  <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing responsive, mobile-first projects on the web.</p>
</div>

<nav class="navbar navbar-expand-sm bg-white navbar-light sticky-top">
  <!-- Brand -->
  <a class="navbar-brand" href="/">SPRING</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
		<li class="nav-item"><a href="/bbs/list" class="nav-link">게시판</a></li>
		<sec:authorize access="isAnonymous()">
			<li class="nav-item" id="loginOn"><a href="/login/login" class="nav-link">로그인</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li class="nav-item" id="myModify"><a href="/member/memberList" class="nav-link">회원목록</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li class="nav-item" id="myModify"><a href="/member/memberModify/${user.username}" class="nav-link">내정보</a></li>
			<li class="nav-item" id="loginOff"><a href="/login/logOut" class="nav-link">로그아웃</a></li>
		</sec:authorize>
    </ul>
  </div> 
  <form class="form-inline" action="/action_page.php">
  <input class="form-control mr-sm-2" type="text" placeholder="Search">
  <button class="btn btn-success" type="submit">Search</button>
  </form>
  
</nav>

 

