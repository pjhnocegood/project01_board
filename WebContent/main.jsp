<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta content="charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title> 
<!-- style & font -->
<link rel="stylesheet" href="./css/reset.css">
<style type="text/css">
#wrap{width:1400px; margin:0 auto; border:1px solid red;}
header{width:100%; height:100px; line-height:100px; text-align:center; border:1px solid orange;}

nav{width:100%; height:50px; line-height:50px; text-align:center; border:1px solid yellow;}
nav .nav_inner li{width:25%; display:inline-block; border:1px solid #333; box-sizing: border-box; moz-box-sizing: border-box; -webkit-box-sizing: border-box;}
nav .nav_inner a{width: 100%; display: block;}

section{width:100%; border:1px solid blue;}
section .sect_inner{width:1000px; margin:0 auto; margin-top:20px; margin-bottom:20px;}
section .sect_inner .board_BAE{height:300px; background-color:skyblue;}
section .sect_inner .board_KIM{height:300px; background-color:pink; margin-top:20px;}
section .sect_inner .board_PARK{height:300px; background-color:orange; margin-top:20px;}

footer{width:100%; height:50px; line-height:50px; text-align:center; background-color:#ececec; border:1px solid navy;}
footer em{font-style: normal; font-size:14px;}
</style>
</head>
<body>
<div id="wrap">
	<header>
		<h1>게시판(BOARD) 프로젝트</h1>
	</header>
	<nav>
		<div class="nav_inner">
			<ul>
				<li><a href="#">전체</a></li><li><a href="#">기열 게시판</a></li><li><a href="#">민기 게시판</a></li><li><a href="#">진환 게시판</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<div class="sect_inner">
			<div class="board_BAE">
				<jsp:include page="board_BAE.jsp" />
			</div>
			
			<div class="board_KIM">
				민기 게시판
			</div>
			
			<div class="board_PARK">
				진환 게시판
			</div>
		</div>
	</section>
	<footer>
		<address>
			<em>Copyrigh &copy; 2018 Board. All Rights Reserved.</em>
		</address>
	</footer>
</div>
</body>
</html>