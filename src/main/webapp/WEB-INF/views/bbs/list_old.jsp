
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/Webedu/public/bootstrap/dist/css/bootstrap.css">
  <script src="/Webedu/public/jquery/jquery-3.3.1.js"></script>
  <script src="/Webedu/public/bootstrap/dist/js/bootstrap.js"></script> -->
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
<!-- 
<script>
$(function() {
	$('#search').click(function() {
		self.location = "list.do?reqPage=1" 
					   +"$seachType='"
					   +$("select[name=searchType]").val()
					   +"'"
					   +"&keyword='"
					   +$("input[name=keyword]").val()
					   +"'";
		console.log(self.locaion.toString());					   
	})			
});
</script>
 -->
<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>
  <br>
  
<%--   <form class="form-inline my-2 my-lg-0">
	  <select class="custom-select my-1 mr-sm-2" name="searchType">
	    <option value="TC" <C:out value="${findCriteria.searchType == 'TC' ? 'selected' : '' }" />>제목+내용</option>
	    <option value="T" <C:out value="${findCriteria.searchType == 'T' ? 'selected' : '' }" />>제목</option>
	    <option value="C" <C:out value="${findCriteria.searchType == 'C' ? 'selected' : '' }" />>내용</option>
	    <option value="W" <C:out value="${findCriteria.searchType == 'W' ? 'selected' : '' }" />>작성자</option>
	  </select>
	
	  <input class="form-control mr-sm-2" name="keyword" type="search" aria-label="Search" placeholder="검색 내용 입력" value="${findCriteria.keyword}">
	  <button class="btn btn-outline-primary my-2 my-sm-0" type="submit" id="search">Search</button>
  </form>
	
  <p style="text-align: right">
  <a href="/bbs/list" class="btn btn-primary btn active" role="button" aria-pressed="true">목록 </a>
  <a href="/Webedu/bbs/write_view.do?reqPage=${pageCriteria.recordCriteria.reqPage}" class="btn btn-primary btn active" 
     role="button" aria-pressed="true" id="write">글쓰기</a>
  <br></p> --%>
  
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
        <td id = "tdnum">${list.bNum}</td>
        <!-- <td id = "tdtitle" style="cursor:pointer;" onClick="location.href='/Webedu/bbs/view.do?bNum='+${dto.bNum}">${dto.bTitle}</td>  -->
        <td id = "tdtitle">
        	<C:forEach begin="1" end="${dto.bIndent}">&nbsp;&nbsp; RE: </C:forEach>
        	<%-- <a class="text-dark" href="view.do?${pageCriteria.makeSearchURL(pageCriteria.recordCriteria.reqPage)}&bNum=${dto.bNum}"> --%>
        	${dto.bTitle}
        	<!-- </a> -->
        	</td>
        <%-- <a href="/Webedu/bbs/view.do?no=${dto.bNUM}"></a> --%> 
        <td id = "tdname">${dto.bName}</td>
        <td id = "tdhit">${dto.bHit}</td>
        <td id = "tdcdate">${dto.bCDate}</td>
      	</tr>
    	</C:forEach>
    </tbody>
  </table>
	  		   
<%-- 	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	  	<li class="page-item">
	  	<a class="page-link" href="list.do?${pageCriteria.makeSearchURL(1)}" tabindex="-1">◀</a>
	  	</li>
	    <li class="page-item">
	      <C:if test="${pageCriteria.prev}"> <!-- pageCreateria.isPrev() -->
	      <a class="page-link" href="list.do?${pageCriteria.makeSearchURL(pageCriteria.startPage-1)}" tabindex="-1">◁</a>
	      </C:if>
	    </li>
	    <C:forEach var="pageNum" begin="${pageCriteria.getStartPage()}" end="${pageCriteria.getEndPage()}" step="1">
	   	 	<C:if test="${pageNum eq pageCriteria.recordCriteria.reqPage}">
	    		<li class="page-item active"><a class="page-link" href="list.do?${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	   		<C:if test="${pageNum ne pageCriteria.recordCriteria.reqPage}">
	    	<li class="page-item"><a class="page-link" href="list.do?${pageCriteria.makeSearchURL(pageNum)}">${pageNum}</a></li>
	    	</C:if>
	    </C:forEach>
	    <li class="page-item">
	      <C:if test="${pageCriteria.next}"> <!-- pageCreateria.isNext() -->
	      <a class="page-link" href="list.do?${pageCriteria.makeSearchURL(pageCriteria.endPage+1)}">▷</a>
	      </C:if>
	    </li>
	    <li class="page-item">
	  	<a class="page-link" href="list.do?${pageCriteria.makeSearchURL(pageCriteria.finalEndPage)}" tabindex="-1">▶</a>
	  	</li>
	  </ul>
	</nav> --%>
</div>

</body>

</html>