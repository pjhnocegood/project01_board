<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
#wrap{min-width:1400px; margin:0 auto;}
header{height:100px; line-height:100px; text-align:center;}

nav{height:50px; line-height:50px; text-align:center;}
nav .nav_inner{width:1400px; margin:0 auto;}
nav .nav_inner li{width:25%; display:inline-block; border:1px solid #f1efef; border-bottom:0; border-right:0; box-sizing: border-box; moz-box-sizing: border-box; -webkit-box-sizing: border-box;}
nav .nav_inner .r1{border-right:1px solid #f1efef;}
nav .nav_inner a{width: 100%; display: block; color:#4d6065;}

section{}
section .sect_inner{width:1400px; margin:0 auto; padding:30px 0 30px 0; border:1px solid #f1efef; box-sizing: border-box; moz-box-sizing: border-box; -webkit-box-sizing: border-box;}
section .sect_inner .board_BAE{width:1300px; margin:0 auto;}
section .sect_inner .board_KIM{width:1300px; height:300px; margin:0 auto; background-color:pink; margin-top:20px;}
section .sect_inner .board_PARK{width:1300px; height:300px; margin:0 auto; background-color:orange; margin-top:20px;}

footer{height:50px; line-height:50px; text-align:center; background-color:#ececec; margin-top:40px;}
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
				<li><a href="#" style="background-color:#00b0d9; color:#fff;">전체</a></li><li><a href="#">기열 게시판</a></li><li><a href="#">민기 게시판</a></li><li class="r1"><a href="./board_list_park.do">진환 게시판</a></li>
			</ul>
		</div>
	</nav>
	<section>
		<div class="sect_inner">
			<div class="board_BAE">
				<jsp:include page="board_BAE.jsp" />
			</div>
			
			<div class="board_KIM">
				<jsp:include page="board_kim.jsp" />
			</div>
			
			<div class="board_PARK">
				<jsp:include page="board_park.jsp" />
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