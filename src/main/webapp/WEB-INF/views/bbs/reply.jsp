<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/Webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/Webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>Insert title here</title>
<style>
body { padding: 1px; }
</style>
<script>

//var bNum = 1781;
var bNum = ${view.bNum};
var reReqPage = 1;

$(function() {
	// 댓글 수정 양식 숨기기 
	$("#modifyDiv").hide();
	
	// 댓글 목록 가져오기 
	// replyList();
	replyList(reReqPage);
	
	//좋아요 완료
 	$("#reply").on("click", "#goodBtn", function() {
 		var li = $(this).parent().parent();
 		var rNum = li.attr("data-rNum");
		var good = "good";
		
		console.log(rNum);
		
		$.ajax({
			type: "POST",
			url: "/Webedu/rbbs/good",
			dataType: "text",
			data: {
				rNum : rNum, 
				goodOrBad : good
			},
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
 		var rNum = li.attr("data-rNum");
		var bad = "bad";
		
		$.ajax({
			type: "POST",
			url: "/Webedu/rbbs/bad",
			dataType: "text",
			data: {
				rNum : rNum, 
				goodOrBad : bad
			},
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
 		var rNum = li.attr("data-rNum");
 		var reReplyWriter = $("#reReplyWriter", li).val();
		var reReplyContent = $("#reReplyContent", li).val();
		
		console.log(rNum);
		
		$.ajax({
			type: "POST",
			url: "/Webedu/rbbs/reReply",
			dataType: "text",
			data: {
				rNum : rNum, 
				rName : reReplyWriter, 
				rContent : reReplyContent
			},
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
 		var rNum = li.attr("data-rNum");
		var modiContent = $("#reModiContent", li).val();
		
		console.log(rNum);
 		console.log(modiContent);

		$.ajax({
			type:"POST",
			url:"/Webedu/rbbs/modify",
			dataType: "text",
			data: {
				rNum: rNum,
				rContent: modiContent
			},
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
 		var rNum = li.attr("data-rNum");
		
		$.ajax({
			type:"POST",
			url:"/Webedu/rbbs/delete",
			dataType: "text",
			data: {
				rNum: rNum,
			},
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
		var writer = $("#writer").val();
		var replyContent = $("#replyContent").val();
		
		$.ajax
		({
			type:"POST",
			url:"/Webedu/rbbs/write",
			dataType: "text",
			data: {
				bNum : bNum,
				rName: writer,
				rContent: replyContent
			},
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
		url: "/Webedu/rbbs/list?bNum="+bNum+"&reReqPage="+reReqPage,
		dataType: "json",
		success: function(data){
			console.log(data);
			console.log(data.result);
			console.log(data.pageCriteria);
			$.each(data.result, function(idx, rec){
				console.log(rec);
				console.log(rec.rnum);
				/* str += "<li data-rNum='"+rec.rnum+"'>"
					+ rec.cdate + " | "
					+ rec.content + " | "
					+ rec.name + " | "
					+ rec.good + " | "
					+ rec.bad + " | "
					+ "<button id='infoBtn'>정보</button>"
					+ "</li>"; */
				str += "<div data-rNum='"+rec.rnum+"'>"
					+ "<label id='nameLb' for='content'><b>"+ rec.name +"</b></label>&nbsp"
					+ "<label id='cdateLb' for='content'>&nbsp"+ rec.cdate +"</label>&nbsp"
					
					+ "<div style='float: right;'>"
					+ "<button id='goodBtn' class='btn btn-outline-danger btn-sm'>Good&nbsp"
					+ "<span class='badge badge-danger badge-pill'>"+ rec.good +"</span></button>&nbsp"
					+ "<button id='badBtn' class='btn btn-outline-warning btn-sm'>Bad&nbsp"
					+ "<span class='badge badge-warning badge-pill'>"+ rec.bad +"</span></button>&nbsp"
					+ "</div>"
					
					+ "<li id='reContent' style='list-style: none;'>"+ rec.content +"</li>"
					
					+ "<div class='btn-group' role='group' aria-label='Basic example' id='reViewMode' style='float: right; padding:1px;'>"
					+ "<button id='reReplyBtn' class='btn btn-outline-primary btn-sm'>답댓글</button>&nbsp"
					+ "<button id='reModifyBtn' class='btn btn-outline-primary btn-sm'>수정</button>&nbsp"
					+ "<button id='reDeleteBtn' class='btn btn-outline-secondary btn-sm'>삭제</button>"
					+ "</div><br></br>"
					
					+ "<div id='reModiDiv' class='row' style='padding: 1px; display:none;'>"
					+ "<div class='col'>"
					+ "<textarea id='reModiContent' cols='50' rows='3' class='form-control'>" + rec.content + "</textarea>"
					+ "<div style='float: right'>"
					+ "<button id='reModiOkBtn' class='btn btn-success btn-sm'>완료</button><br />"
					+ "</div>"
					+ "</div>"
					+ "</div>"
					
					+ "<div id='reReplyDiv' class='row' style='padding: 1px; display:none;'>"
					+ "<div class='col'>"
					+ "<input type='text' id='reReplyWriter' class='form-control' placeholder='작성자명'>"
					+ "<textarea id='reReplyContent' cols='50' rows='3' class='form-control' placeholder='답댓글 내용을 입력해주세요.'></textarea>"
					+ "<div style='float: right'>"
					+ "<button id='reReplyOkBtn' class='btn btn-success btn-sm'>완료</button><br />"
					+ "</div>"
					+ "</div>"
					+ "</div>"
					
					+ "</div>"
					+ "<br></br><br />";
			});
			$("#reply").html(str);
			
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

 <form>
  <div class="row" style="padding: 1px">
    <div class="col" id="replyInfo">
      <input type="text" id="writer" class="form-control" placeholder="작성자명">
    </div>
  </div>
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
</form>
<br></br>

<h4>댓글리스트</h4>

<ul class="list-group" id = "reply">

</ul>


<br />
<nav aria-label="Page navigation example">
<ul class="pagination justify-content-center" id="pageNumList">
	
</ul>
</nav>
</body>
</html>