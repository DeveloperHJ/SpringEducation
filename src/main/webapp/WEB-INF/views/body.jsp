<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" scope="session" />

  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
  }
  </style>
  
<section>
  
  <div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
<<<<<<< HEAD
      <img src="/images/image1.JPG" alt="" />
=======
      <!-- <img src="https://www.w3schools.com/bootstrap4/la.jpg" alt="Los Angeles" width="1100" height="500"> -->
      <img src="/images/image1.JPG" alt="Sky Bridge" />
>>>>>>> refs/remotes/origin/master
    </div>
    <div class="carousel-item">
<<<<<<< HEAD
      <img src="/images/image2.JPG" alt="" />
=======
      <!-- <img src="https://www.w3schools.com/bootstrap4/chicago.jpg" alt="Chicago" width="1100" height="500"> -->
      <img src="/images/image2.JPG" alt="Mountain Lake" />
>>>>>>> refs/remotes/origin/master
    </div>
    <div class="carousel-item">
<<<<<<< HEAD
      <img src="/images/image3.JPG" alt="" />
=======
      <!-- <img src="https://www.w3schools.com/bootstrap4/ny.jpg" alt="New York" width="1100" height="500"> -->
      <img src="/images/image3.JPG" alt="High way" />
>>>>>>> refs/remotes/origin/master
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

</section>