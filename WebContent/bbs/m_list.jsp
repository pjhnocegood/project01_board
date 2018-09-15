<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게 시 판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<link rel="stylesheet" href="<%=cp%>/bbs/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/bbs/css/list.css" type="text/css"/>

<script type="text/javascript">

	function sendIt() {
		
		var f = document.searchForm;
		
		f.action = "<%=cp%>/bbs/m_list.do";
		f.submit();
		
	}

</script>

</head>

<body>
<div id="bbsList">
	<div id="bbsList_title">
	게 시 판 (Servlet)
	</div>

	<div id="bbsList_header">
		<div id="leftHeader">
		 <!--  <form name="searchForm" method="post" action="">
			<select name="searchKey" class="selectFiled">
				<option value="boardSubject_kmk">제목</option>
				<option value="userId_kmk">작성자</option>
				<option value="boardContent_kmk">내용</option>
			</select>
			<input type="text" name="searchValue" class="textFiled"/>
			<input type="button" value=" 검 색 " class="btn2" 
			onclick="sendIt();"/>
		  </form>  -->
		</div>
		<div id="rightHeader">
		<c:choose>
			<c:when test="${empty sessionScope.customInfo.userId_kmk }">
			<input type="button" value=" 로그인 " class="btn2" 
			onclick="javascript:location.href='${loginUrl} ';"/>
			</c:when>
			<c:otherwise>
			<input type="button" value=" 로그아웃 " class="btn2" 
			onclick="javascript:location.href='${logoutUrl} ';"/>
			<input type="button" value=" 글올리기 " class="btn2" 
			onclick="javascript:location.href='${createdUrl}';"/>
			</c:otherwise>
		</c:choose>
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
		<!-- jstl로 가져옴 -->
		<c:forEach var="b_dto" items="${lists }">
			<dl>
				<dd class="num">${b_dto.listNum }</dd>
				<dd class="subject">
				<a href="${articleUrl }&boardNo_kmk=${b_dto.boardNo_kmk}">
				${b_dto.boardSubject_kmk }</a></dd>
				<dd class="name">${b_dto.userId_kmk }</dd>
				<dd class="created">${b_dto.boardDate_kmk }</dd>
				<dd class="hitCount">${b_dto.boardCount_kmk }</dd>
			</dl>
		</c:forEach>

		</div>
		<div id="footer">
			<p>
				<c:if test="${dataCount!=0 }">
					${pageIndexList }
				</c:if>
				
				<c:if test="${dataCount==0 }">
					등록된 게시물이 없습니다.
				</c:if>
			</p>
		</div>
	</div>
</div>
</body>

</html>