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

<link rel="stylesheet" href="<%=cp%>/board/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/board/css/article.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kmk_list.css" type="text/css"/>

</head>

<body>

<div id="bbs">
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
		</div>
	</div>
	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">내용</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">비밀번호</dt>
				
			</dl>
		</div>
		<div id="lists">
			
			
			
			
					<dl>
				<dd class="num">22</dd>
				<dd  class="subject">33</dd>
				<dd class="name">33</dd>
				<dd class="created">44</dd>		
			 	<dd class="hitCount">55</dd>
			 		
					</dl>
					

		</div>

		<div id="footer">
			<p>
				<a href="#">1</a>
				<a href="#">2</a>
			</p>
		</div>
	</div>
	


</div>

<br/>&nbsp;<br/>
</body>

</html>