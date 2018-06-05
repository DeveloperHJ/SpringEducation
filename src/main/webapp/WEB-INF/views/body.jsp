<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section>
<div class="parallax-container">
      <div class="parallax"><img src="http://3.bp.blogspot.com/-Z1uVLy6iCno/Ut9kEEW3p8I/AAAAAAAABeo/sK7hFr6QwoQ/s1600/earth_8-wallpaper-2560x1440.jpg"></div>
    </div>
    <div class="section white">
      <div class="row container">
	    <c:choose>
	 		<c:when test="${login.id eq null}">
			<h3 class="center">안녕하세요?</h3>	
		</c:when>
	   	<c:otherwise>
	   		<h3 class="center">${login.name}님, <br>반가워요!</h3>	
	
	   		  <div class="carousel">
			    <a class="carousel-item" href="#one!"><img src="https://lorempixel.com/250/250/nature/1"></a>
			    <a class="carousel-item" href="#two!"><img src="https://lorempixel.com/250/250/nature/2"></a>
			    <a class="carousel-item" href="#three!"><img src="https://lorempixel.com/250/250/nature/3"></a>
			    <a class="carousel-item" href="#four!"><img src="https://lorempixel.com/250/250/nature/4"></a>
			    <a class="carousel-item" href="#five!"><img src="https://lorempixel.com/250/250/nature/5"></a>
			  </div>
	   </c:otherwise>
	   </c:choose>
      </div>
    </div>
    <div class="parallax-container">
      <div class="parallax"><img src="http://4.bp.blogspot.com/-JdQOwyxlKBg/Ut9kEID6tcI/AAAAAAAABes/G8XWnlB9kc8/s1600/beautiful_space_view-wallpaper-2560x1440.jpg"></div>
</div>
</section>