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

<link rel="stylesheet" href="<%=cp%>/bbs/css/style.css" type="text/css"/>
<link rel="stylesheet" href="<%=cp%>/bbs/css/created.css" type="text/css"/>

<script type="text/javascript" src="<%=cp%>/bbs/js/util.js"></script>
<script type="text/javascript">

    function sendIt() {
       
		f = document.myForm;

        f.action = "<%=cp%>/bbs/m_updated_ok.do?pageNum=${pageNum}";
        f.submit();
    }

</script>

</head>

<body>

<div id="bbs">
	<div id="bbs_title">
	수정하기
	</div>

	<form name="myForm" method="post" action="">
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				      <input type="text" name="boardSubjec_kmk" value="${b_dto.boardSubject_kmk }" size="74" maxlength="100"  class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				      <input type="text" name="userId_kmk" value="${b_dto.userId_kmk }" size="35" maxlength="20" class="boxTF" disabled="disabled" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				      <input type="text" name="userEmail_kmk" value="${b_dto.userEmail_kmk }" size="35" maxlength="50" class="boxTF" disabled="disabled" />
				</dd>
			</dl>
		</div>

		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				      <textarea name="boardContent_kmk" cols="63" rows="12" class="boxTA">${b_dto.boardContent_kmk }</textarea>
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_noLine">
		
		</div>
	</div>

	<div id="bbsCreated_footer">
	
		<input type="hidden" name="boardNo_kmk" value="${b_dto.boardNo_kmk }"/>
		<input type="hidden" name="pageNum" value="${pageNum }"/>
		
	
        <input type="button" value=" 수정하기 " class="btn2" 
        onclick="sendIt();"/>
        <input type="button" value=" 수정취소 " class="btn2" 
        onclick="javascript:location.href='<%=cp%>/bbs/m_list.do?pageNum=${pageNum }';"/>
	</div>

    </form>
</div>

</body>

</html>