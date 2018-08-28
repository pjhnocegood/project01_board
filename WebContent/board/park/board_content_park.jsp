<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게 시 판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	
<link rel="stylesheet" href="<%=cp%>/board/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/board/css/article.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/board/park/css/kmk_list.css" type="text/css"/>

</head>

<body>

<div id="bbs">
<form name="content_from" id="content_from" method="post" >
	
	<div id="bbs_title">
	게 시 판
	</div>
	<div id="bbsArticle">
		<div id="bbsArticle_header">
			${info.board_subject}
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>${info.board_writer}</dd>
				<dt>좋아요</dt>
				<dd>${info.board_like}</dd>
			</dl>
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${info.board_dt}</dd>
				<dt>조회수</dt>
				<dd>${info.board_view}</dd>
			</dl>
		</div>
		<div id="bbsArticle_content">
			<table width="600" border="0">
			<tr><td style="padding: 20px 80px 20px 62px;" valign="top" height="200">
			${info.board_content}
			</td></tr>
			</table>
		</div>
		
	</div>
	<div class="bbsArticle_noLine" style="text-align:right">
		    From : 127.0.0.1
	</div>
	<div id="bbsArticle_footer">
		<div id="leftFooter">
               <input type="button" value=" 수정 " class="btn2" onclick="location.href='./board_update_park.do?board_num=${info.board_num}'"/>
               <input type="button" value=" 삭제 " class="btn2" 
               onclick="location.href='./board_delete_park.do?board_num=${info.board_num}'"/>
		</div>
		<div id="rightFooter">
               <input type="button" value=" 리스트 " class="btn2" onclick="location.href='./board_list_park.do'"/>
		</div>b
	</div>
	<div>
	내용: <input type="text" id="rf_content" name="rf_content" style="width: 500px">&nbsp;&nbsp;
	<input type="button" value="글쓰기" onclick="rf_add();">
	</div>
	<br>
	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="num" style="width: 300px">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="created" >삭제</dt>
			
			</dl>
		</div>
		<div id="lists">
					<dl>
				<dd class="num">5</dd>
				<dd  class="rf_num" >ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</dd>
				<dd class="name">5</dd>
				<dd class="created">5</dd>		
			 	<dd class="created" >삭제</dd>		
					</dl>
					<dl>
				<dd class="num">5</dd>
				<dd  class="rf_num" >ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</dd>
				<dd class="name">5</dd>
				<dd class="created">5</dd>		
			 	<dd class="created" >삭제</dd>		
					</dl>
		</div>
		<input type="hidden" id="board_num" name="board_num" value="${info.board_num}">
		
		</div>
		</form>
</div>



<br/>&nbsp;<br/>

</body>
<script type="text/javascript">
function rf_add(){ 
	  $.ajax(
				{
					url : "./board_rf_insert_park.do",
					
	                data: $('#content_from').serializeArray(),
					type: 'Post',
					success : function(result) {
						
						alert('등록 되었습니다.')
						rf_list();
						
					},
					error : function() {
						
					}
				})
}

function rf_list(){ 
	  $.ajax(
				{
					url : "./board_rf_list_park.do",
					
	                data: $('#content_from').serializeArray(),
					type: 'Post',
					dataType : 'json',
					success : function(result) {
					var response=result.list;
						
						var row="";
					
						for (var i = 0; i < response.length; i++) {
							row += "<dl>"
								row += "<dd class=num>"+response[i].rf_num+"</dd>";
								row += "<dd  class=rf_num style=width: 300px>"+response[i].rf_content+"</dd>	";
								row += "<dd class=name>"+response[i].rf_writer+"</dd>";
								row += "<dd class=rf_dt>"+response[i].rf_dt+"</dd>";
								row += "<dd class=created>삭제</dd>";
								row += "</dl>"
							}
						
						//aaa
						$("#lists").html("");
						$("#lists").append(row);
	
						
						
					},
					error : function() {
						
					}
				})
}
window.onload= function() {
	rf_list();
}


</script>

</html>