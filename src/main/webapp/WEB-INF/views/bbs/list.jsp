
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>
<title>Insert title here</title>

<jsp:include page="../header.jsp" />

<style>
#write { align: right }
th, #tdnum, #tdname, #tdhit, #tdcdate { text-align: center }
#num { width: 8% }
#title { width: 52% }
#name  { width: 20% }
#hit { width: 10% }
#cdate {width: 10% }

   
.page-link {
  position: relative;
  display: block;
  padding: 0.5rem 0.75rem;
  margin-left: -1px;
  line-height: 1.25;
  color: #000000;   /* 선택 안된 숫자 색상 */
  background-color: #FFFFFF; /* 선택 안된 버튼 색상 */
  border: 1px solid #E9ECEF; /* 선택 안된 버튼 테두리 */
}
.page-item.disabled .page-link {
  color: #FF0000;
  pointer-events: none;
  cursor: auto;
  background-color: #CEFFCE;
  border-color: #718393;
}
.page-item.active .page-link {
  z-index: 1;
  color: #000000;/* 선택된 버튼 폰트 색상 */
  background-color: #E9ECEF;/* 선택된 버튼 색상 */
  border-color: #E9ECEF;/* 선택된 버튼 테두리 */
}
.page-link:focus, .page-link:hover {
  color: #000000;/* 마우스 올라갔을때 폰트 색상 */
  text-decoration: none;
  background-color: #E9ECEF;
  border-color: #E9ECEF;
}
</style>

</head>

<body>
<jsp:include page="../navbar.jsp" />

<div class="container">
  <!-- <h2>Basic Table</h2> -->
	
  <div class="row justify-content-sm-end">

  </div>
  	<br>

  <form action="/bbs/list">
 <!--  <div class="row justify-content-sm-end"> -->
 <div class="row">
	  <select class="custom-select col-sm-2" name="searchType">
	    <option value="TC" <C:out value="${findCriteria.searchType eq 'TC' ? 'selected' : '' }" />>제목+내용</option>
	    <option value="T" <C:out value="${findCriteria.searchType eq 'T' ? 'selected' : '' }" />>제목</option>
	    <option value="C" <C:out value="${findCriteria.searchType eq 'C' ? 'selected' : '' }" />>내용</option>
	    <option value="W" <C:out value="${findCriteria.searchType eq 'W' ? 'selected' : '' }" />>작성자</option>
	  </select>
	
	  <input class="form-control col-sm-3" name="keyword" type="search" aria-label="Search" placeholder="검색 내용 입력" value="${findCriteria.keyword}">
	  <button class="btn btn-sm btn-outline-dark my-2 my-sm-0" type="submit" id="search">Search</button>
	  
	  <a href="/bbs/list" class="btn btn-sm btn-outline-info ml-auto" role="button" aria-pressed="true">목록 </a>
  	  <a href="/bbs/write" class="btn btn-sm btn-outline-info" role="button" aria-pressed="true" id="write">글쓰기</a>
  </div>
 </form>

	<br>

  <table class="table table-hover">
  
      <thead>
      <tr>
        <th id = "num">#</th>
        <th id = "title">제목</th>
        <th id = "name">작성자</th>
        <th id = "hit">조회수</th>
        <th id = "cdate">작성일</th>
      </tr>
    </thead>
    <tbody>
    	<!-- BbsListCmd.java에서 setAttribute 해주었던 alist의 이름 "list"를 불러온다.  -->
    	<C:forEach items="${list}" var = "dto">	
    	<tr>
        <td id = "tdnum">${dto.BNum}</td>
        <td id = "tdtitle">
        	<C:if test="${dto.BIndent > 0}">
        		<C:forEach begin="1" end="${dto.BIndent}">&nbsp;&nbsp;</C:forEach>
        		<img src="/images/icon_reply.gif">
        	</C:if>
        	<a class="text-dark" href="/bbs/view?${pageCriteria.makeSearchURL(pageCriteria.recordCriteria.reqPage)}&bnum=${dto.BNum}">
        	${dto.BTitle}
        	</a>
        </td>
        <td id = "tdname">${dto.BName}</td>
        <td id = "tdhit">${dto.BHit}</td>
        <td id = "tdcdate">${dto.BCDate}</td>
      	</tr>
    	</C:forEach>
    </tbody>
  </table>
  
  <nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	  	<li class="page-item">
	  	<a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(1)}" tabindex="-1">◀</a>
	  	</li>
	    <li class="page-item">
	      <C:if test="${pageCriteria.prev}"> <!-- pageCreateria.isPrev() -->
	      <a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(pageCriteria.startPage-1)}" tabindex="-1">◁</a>
	      </C:if>
	    </li>
	    <C:forEach var="pageNum" begin="${pageCriteria.getStartPage()}" end="${pageCriteria.getEndPage()}" step="1">
	   	 	<C:if test="${pageNum eq pageCriteria.recordCriteria.reqPage}">
	    		<li class="page-item active"><a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	   		<C:if test="${pageNum ne pageCriteria.recordCriteria.reqPage}">
	    	<li class="page-item"><a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	    </C:forEach>
	    <li class="page-item">
	      <C:if test="${pageCriteria.next}"> <!-- pageCreateria.isNext() -->
	      <a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(pageCriteria.endPage+1)}">▷</a>
	      </C:if>
	    </li>
	    <li class="page-item">
	  	<a class="page-link" href="/bbs/list?${pageCriteria.makeSearchURL(pageCriteria.finalEndPage)}" tabindex="-1">▶</a>
	  	</li>
	  </ul>
  </nav> 
</div>
</body>

</html>