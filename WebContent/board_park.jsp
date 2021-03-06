<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta content="charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kmk_style.css" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/kmk_list.css" type="text/css"/>

</head>
<body>
<div id="bbsList">
	<div id="bbsList_title">
	 
	</div>

	<div id="bbsList_header">
		<div id="leftHeader">
		  <form name="searchForm" method="post" action="">
			<select name="searchKey" class="selectFiled">
				<option value="subject">제목</option>
				<option value="name">작성자</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="searchValue" class="textFiled"/>
			<input type="button" value=" 검 색 " class="btn2" onclick=""/>
		  </form>
		</div>
		
		<div id="rightHeader">
			<input type="button" value=" 글올리기 " class="btn2" onclick="board_write();"/>
			<input type="button" value=" 로그인 " class="btn2" onclick="location.href='./member/park/login.jsp'"/>
		</div>
	</div>
	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div>
		<div id="lists">
			
			
			
			<c:forEach var="item" items="${board_list}">
					<dl>
				<dd class="num">${item.board_num}</dd>
				<dd  class="subject">
				<a href="./board_content_park.do?board_num=${item.board_num}">
				${item.board_subject}
				</a></dd>
				<dd class="name">${item.board_writer}</dd>
				<dd class="created">${item.board_dt}</dd>		
			 	<dd class="hitCount">${item.board_view}</dd>
			 		
					</dl>
					</c:forEach>

		</div>
		<div id="footer">
			<p>
				<a href="./board_list_park.do?select_page=${select_page-5}">←</a>
				
				<c:forEach var="i" begin="${start_page}" end="${end_page}">						
							<a href="./board_list_park.do?select_page=${i}">${i}</a>
								
					</c:forEach>
				<a href="./board_list_park.do?select_page=${select_page+5}">→</a>
					
			</p>
		</div>
	</div>
</div>

</body>
<script type="text/javascript">
function board_write(){
	location.href='./board_write_park.do';
}

</script>

</html>