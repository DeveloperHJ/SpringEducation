<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>

<title>Insert title here</title>

<style>
body { padding: 1px; }
</style>

<script>
// ajax 실행시 마다 http header에 csrf토큰 추가-------------------------
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});
// ---------------------------------------------------------------------

//var bnum = 1781;
var bnum = ${view.BNum};
var reReqPage = 1;

// 세션 정보 
 var login_id = "${user.username}";
var login_name = "${user.name}"; 
/* 
var login_id = "admin@kh.com";
var login_naem = "관리자"; */

$(function() {
	// 댓글 목록 가져오기 
	// replyList();
	replyList(reReqPage);
	
	//좋아요 완료
 	$("#reply").on("click", "#goodBtn", function() {
 		var li = $(this).parent().parent();
 		var rnum = li.attr("data-rnum");
		
		console.log(rnum);
		
		$.ajax({
			type: "PUT",
			url: "/rbbs/good/"+rnum,
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",
			data: JSON.stringify({
				rnum : rnum, 
				goodOrBad : "good"
			}),
			success: function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		}); 
	}); 
	
	//별로 완료
	$("#reply").on("click", "#badBtn", function() {
		var li = $(this).parent().parent();
 		var rnum = li.attr("data-rnum");
		
		$.ajax({
			type: "PUT",
			url: "/rbbs/bad/"+rnum,
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",
			data: JSON.stringify({
				rnum : rnum, 
				goodOrBad : "bad"
			}),
			success: function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		});
	});
	
	// 리댓 버튼 처리
	$("#reply").on("click", "#reReplyBtn", function() {
		var li = $(this).parent().parent();

		$("#reReplyDiv", li).slideToggle("slow");
	});
	
	// 리댓 달기 
	$("#reply").on("click", "#reReplyOkBtn", function() {
		var li = $(this).parent().parent().parent().parent();
 		var rnum = li.attr("data-rnum");
		var reReplyContent = $("#reReplyContent", li).val();
		
		console.log(rnum);
		
		$.ajax({
			type: "POST",
			url: "/rbbs/reReply",
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",
			data: JSON.stringify({
				rnum : rnum, 
				rid : login_id,
				rname : login_name, 
				rcontent : reReplyContent
			}),
			success: function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		});
	});
	
	// 수정 버튼 처리
	$("#reply").on("click", "#reModifyBtn", function() {
		var li = $(this).parent().parent();
		
 		$("#reModiDiv", li).slideToggle("slow");
	});
	
	// 댓글 수정
	$("#reply").on("click", "#reModiOkBtn", function() {
		var li = $(this).parent().parent().parent().parent();
 		var rnum = li.attr("data-rnum");
		var modiContent = $("#reModiContent", li).val();
		
		console.log(rnum);
 		console.log(modiContent);

		$.ajax({
			type:"PUT",
			url:"/rbbs/modify",
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",
			data: JSON.stringify({
				rnum: rnum,
				rcontent: modiContent
			}),
			success:function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		}); 
	}); 
	
	// 댓글 삭제
	$("#reply").on("click", "#reDeleteBtn", function() {
		var li = $(this).parent().parent();
 		var rnum = li.attr("data-rnum");
		
		$.ajax({
			type:"DELETE",
			url:"/rbbs/delete/"+rnum,
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",

			success:function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		});
	});
	
	// 댓글 작성 클릭 시 수행 로직 
	$("#replyBtn").click(function() {
		var replyContent = $("#replyContent").val();
		alert("등록클릭" + replyContent);
		
		$.ajax
		({
			type:"POST",
			url:"/rbbs/write",
			headers:{
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType: "text",
			data: JSON.stringify({
				bnum : bnum,
				rid : login_id,
				rname: login_name,
				rcontent: replyContent
			}),
			success:function(result){
				replyList(reReqPage);
			},
			error:function(e){
				console.log("실패" + e)
			}
		});
	});
	
	// 페이지번호 클릭시 이벤트 처리 
	$("#pageNumList").on("click", "a", function(evt) {
		evt.preventDefault();
		reqPage = $(this).attr("href");
		replyList(reqPage);
	});
	
});


// 요청페이지 댓글 목록 가져오기 
function replyList(reReqPage) {
	var str = "";

	$.ajax({
		type: "GET",
		url: "/rbbs/map/"+bnum+"/"+reReqPage,
		dataType: "json",
		success: function(data){
			console.log(data);
			console.log(data.item);
			console.log(data.pageCriteria);
			$.each(data.item, function(idx, rec){
				console.log(rec);
				console.log(rec.rnum);

				str += "<div data-rnum='"+rec.rnum+"'>";
			for(var i=0; i < rec.rindent; i++) {
				str += "&nbsp;&nbsp;";
			}	 			
			if(rec.rindent > 0){
				str +=	"<img alt='' src='/images/icon_reply.gif'>";
			}	
				str += "<label id='nameLb' for='content'><b>"+ rec.rname +"</b></label>&nbsp"
					+ "<label id='cdateLb' for='content'>&nbsp"+ rec.rcdate +"</label>&nbsp"
					
					+ "<div style='float: right;'>"
					+ "<button id='goodBtn' class='btn btn-outline-danger btn-sm'>Good&nbsp"
					+ "<span class='badge badge-danger badge-pill'>"+ rec.rgood +"</span></button>&nbsp"
					+ "<button id='badBtn' class='btn btn-outline-warning btn-sm'>Bad&nbsp"
					+ "<span class='badge badge-warning badge-pill'>"+ rec.rbad +"</span></button>&nbsp"
					+ "</div>"
					+ "<li id='reContent' style='list-style: none;'>";
					
			for(var i=0; i < rec.rindent; i++) {
				str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
				str += rec.rcontent +"</li>"
					+ "<div aria-label='Basic example' id='reViewMode' style='float: right; padding:1px;'>"
					+ "<button id='reReplyBtn' class='btn btn-outline-primary btn-sm'>답댓글</button>&nbsp"
					+ "<button id='reModifyBtn' class='btn btn-outline-secondary btn-sm'>수정</button>&nbsp"
					+ "<button id='reDeleteBtn' class='btn btn-outline-secondary btn-sm'>삭제</button>"
					+ "</div><br></br>"
					
					+ "<div id='reModiDiv' class='row' style='padding: 1px; display:none;'>"
					+ "<div class='col'>"
					+ "<textarea id='reModiContent' cols='50' rows='3' class='form-control'>" + rec.rcontent + "</textarea>"
					+ "<div style='float: right'>"
					+ "<button id='reModiOkBtn' class='btn btn-success btn-sm'>완료</button><br />"
					+ "</div>"
					+ "</div>"
					+ "</div>"
					
					+ "<div id='reReplyDiv' class='row' style='padding: 1px; display:none;'>"
					+ "<div class='col'>"
					+ "<textarea id='reReplyContent' cols='50' rows='3' class='form-control' placeholder='답댓글 내용을 입력해주세요.'></textarea>"
					+ "<div style='float: right'>"
					+ "<button id='reReplyOkBtn' class='btn btn-success btn-sm'>완료</button><br />"
					+ "</div>"
					+ "</div>"
					+ "</div>"
					
					+ "</div>";
			});
			$("#reply").html(str);
			
			console.log(data.item);
			
			//페이지 리스트 호출 
			showPageList(data.pageCriteria);
		},
		error: function(error){
			console.log("실패"+error);
		}
	});
}

// 페이지 리스트 
function showPageList(pageCriteria){
	console.log(pageCriteria);
	var str = "";
	
	// 이전페이지
	if(pageCriteria.prev){
		str += "<li class='page-item'><a class='page-link' href='1'>◀</a></li>"
		str += "<li class='page-item'><a class='page-link' href='"+ (pageCriteria.startPage-1) +"'>◁</a></li>"
	}
	
	for(var i = pageCriteria.startPage, end=pageCriteria.endPage; i<=end; i++){
		str += "<li class='page-item'><a class='page-link' href='" + i + "'>" + i + "</a></li>";
	}
	
	// 다음페이지
	if(pageCriteria.next){
		str += "<li class='page-item'><a class='page-link' href='"+ (pageCriteria.endPage+1) +"'>▷</a></li>"
		str += "<li class='page-item'><a class='page-link' href='"+ (pageCriteria.finalEndPage) +"'>▶</a></li>"
	}
	
	$("#pageNumList").html(str);
}
</script>
</head>
<body>

<%-- view reqPage : ${view.reqPage } --%>
 <div class="container">
  <div class="row" style="padding: 1px">
  	<div class="col">
      <textarea id="replyContent" cols="50" rows="1" class="form-control" placeholder="댓글 내용을 입력해주세요."></textarea>
  	  <br />
  	</div>
  </div>
  <div class="row" style="text-align: center">
  	<div class="col">
      <button id="replyBtn" class="btn btn-primary btn active">댓글 등록</button>
    </div>
  </div>
<br></br>

<h4>댓글리스트</h4>

<ul class="list-group" id = "reply">

</ul>


<br />
<nav aria-label="Page navigation example">
<ul class="pagination justify-content-center" id="pageNumList">
	
</ul>
</nav>
 </div>
</body>
</html>