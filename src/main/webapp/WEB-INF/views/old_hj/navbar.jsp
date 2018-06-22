<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="user" property="principal" scope="session" />

<nav class="white" role="navigation">
<div class="container">
  <div class="nav-wrapper">
    <a href="/" class="brand-logo">
    <span class="grey-text text-darken-3">SpringFramework</span></a>
  	<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons"><span class="grey-text text-darken-3">menu</span></i></a>
    <ul class="right hide-on-med-and-down">
      <li><a href="/bbs/list"><span class="grey-text text-darken-3">게시판</span></a></li>
		<sec:authorize access="isAnonymous()">
      		<li id="loginOn"><a href="/login/login"><span class="grey-text text-darken-3">로그인</span></a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
 	   	 	<li id="myModify"><a href="/member/memberList"><span class="grey-text text-darken-3">회원목록</span></a></li>
 	   	</sec:authorize>
		<sec:authorize access="isAuthenticated()">
    	    <li id="myModify"><a href="/member/memberModify/${user.username}"><span class="grey-text text-darken-3">내정보</span></a></li>
      		<li id="loginOff"><a href="/login/logOut"><span class="grey-text text-darken-3">로그아웃</span></a></li>
      	</sec:authorize>
    </ul>

    
	<ul class="sidenav" id="mobile-demo">
	    <li><a href=#><span class="grey-text text-darken-3">게시판</span></a></li>
		  <sec:authorize access="isAnonymous()">
	    	<li><a href="/login/login"><span class="grey-text text-darken-3">로그인</span></a></li>
		  </sec:authorize>
		  <sec:authorize access="hasRole('ROLE_ADMIN')">
    		<li id="myModify"><a href="/member/memberList"><span class="grey-text text-darken-3">회원목록</span></a></li>
    	  </sec:authorize>
		  <sec:authorize access="isAuthenticated()">
    	    <li id="myModify"><a href="/member/memberModify/"><span class="grey-text text-darken-3">${user.username}내정보</span></a></li>
	    	<li id="loginOff"><a href="/login/logOut"><span class="grey-text text-darken-3">로그아웃</span></a></li>
          </sec:authorize>
	</ul>
  </div>
</div>
</nav>

 

