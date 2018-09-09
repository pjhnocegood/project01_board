<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta content="charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title> 
<link rel="stylesheet" href="./css/kmk_style.css" type="text/css"/>
<link rel="stylesheet" href="./css/kmk_list.css" type="text/css"/>

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
			<input type="button" value=" 글올리기 " class="btn2" onclick="</created_kim"/>
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
			<dl>
				<dd class="num">1</dd>
				<dd class="subject">스타일 맞추기 힘들다......</dd>
				<dd class="name">김아무개</dd>
				<dd class="created">00/10/10</dd>
				<dd class="hitCount">10</dd>
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

</body>
</html>