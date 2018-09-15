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
<link rel="stylesheet" href="<%=cp%>/bbs/css/article.css" type="text/css"/>

</head>

<body>

<div id="bbs">
	<div id="bbsArticle">
		<div id="bbsArticle_header">
			${b_dto.boardSubject_kmk }
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>${b_dto.userId_kmk }</dd>
				<dt>mail</dt>
				<dd>${b_dto.userEmail_kmk }</dd>
			</dl>
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${b_dto.boardDate_kmk }</dd>
				<dt>조회수</dt>
				<dd>${b_dto.boardCount_kmk }</dd>
			</dl>
		</div>
		<div id="bbsArticle_content">
			<table width="600" border="0">
			<tr><td style="padding: 20px 80px 20px 62px;" valign="top" height="200">
			${b_dto.boardContent_kmk }
			</td></tr>
			</table>
		</div>
		
	</div>
	<div class="bbsArticle_noLine" style="text-align:right">
	</div>
	<div id="bbsArticle_footer">
	<c:choose>
		<c:when test="${sessionScope.customInfo.userId_kmk == b_dto.userId_kmk }">
		<div id="leftFooter">
               <input type="button" value=" 수정 " class="btn2" 
               onclick="javascript:location ='<%=cp%>/bbs/m_updated.do?num=${b_dto.boardNo_kmk }&pageNum=${pageNum}'"/>
               <input type="button" value=" 삭제 " class="btn2" 
               onclick="javascript:location ='<%=cp%>/bbs/m_deleted_ok.do?num=${b_dto.boardNo_kmk }&pageNum=${pageNum}'"/>
		</div>
		</c:when>
	</c:choose>
		<div id="rightFooter">
               <input type="button" value=" 리스트 " class="btn2" 
               onclick="javascript:location ='<%=cp%>/bbs/m_list.do?pageNum=${pageNum }'"/>
		</div>
	</div>

</div>

<br/>&nbsp;<br/>
</body>

</html>