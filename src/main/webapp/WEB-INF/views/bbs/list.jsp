
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
</style>

</head>

<body>
<jsp:include page="../navbar.jsp" />

<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>
  <br>

  <form action="/bbs/searchList">
	  
  	  <div class="input-field col s12 m6">
	    <select name="searchType" class="browser-default">
		    <option value="TC" <C:out value="${findCriteria.searchType == 'TC' ? 'selected' : '' }" />>제목+내용</option>
		    <option value="T" <C:out value="${findCriteria.searchType == 'T' ? 'selected' : '' }" />>제목</option>
		    <option value="C" <C:out value="${findCriteria.searchType == 'C' ? 'selected' : '' }" />>내용</option>
		    <option value="W" <C:out value="${findCriteria.searchType == 'W' ? 'selected' : '' }" />>작성자</option>
	    </select>
	  </div>
	
  	  <div class="input-field col s12 m6">
        <input name="keyword" placeholder="검색 내용 입력" value="${findCriteria.keyword}">
      </div>
<%-- 	  <input class="form-control mr-sm-2" name="keyword" type="search" aria-label="Search" placeholder="검색 내용 입력" 
	  		 value="${findCriteria.keyword}"> --%>
	  <button class="btn btn-outline-primary my-2 my-sm-0" type="submit" id="search">Search</button>
  </form>
	
  <p style="text-align: right">
  <a href="/bbs/list" class="btn btn-primary btn active" role="button" aria-pressed="true">목록 </a>
  <a href="/bbs/write" class="btn btn-primary btn active" 
     role="button" aria-pressed="true" id="write">글쓰기</a>
  <br></p>
  
  <table class="table table-hover">
  
      <thead class="thead-dark">
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
        		RE : 
        	</C:if>
        	<a class="text-dark" href="/bbs/view?bNum=${dto.BNum}">
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
	  	<a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(1)}" tabindex="-1">◀</a>
	  	</li>
	    <li class="page-item">
	      <C:if test="${pageCriteria.prev}"> <!-- pageCreateria.isPrev() -->
	      <a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(pageCriteria.startPage-1)}" tabindex="-1">◁</a>
	      </C:if>
	    </li>
	    <C:forEach var="pageNum" begin="${pageCriteria.getStartPage()}" end="${pageCriteria.getEndPage()}" step="1">
	   	 	<C:if test="${pageNum eq pageCriteria.recordCriteria.reqPage}">
	    		<li class="page-item active"><a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	   		<C:if test="${pageNum ne pageCriteria.recordCriteria.reqPage}">
	    	<li class="page-item"><a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	    </C:forEach>
	    <li class="page-item">
	      <C:if test="${pageCriteria.next}"> <!-- pageCreateria.isNext() -->
	      <a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(pageCriteria.endPage+1)}">▷</a>
	      </C:if>
	    </li>
	    <li class="page-item">
	  	<a class="page-link" href="/bbs/list?reqPage=${pageCriteria.makeSearchURL(pageCriteria.finalEndPage)}" tabindex="-1">▶</a>
	  	</li>
	  </ul>
  </nav> 
</div>
   <div class="input-field col s12">
    <select>
      <option value="" disabled selected>Choose your option</option>
      <option value="1">Option 1</option>
      <option value="2">Option 2</option>
      <option value="3">Option 3</option>
    </select>
    <label>Materialize Select</label>
  </div>
</body>

</html>