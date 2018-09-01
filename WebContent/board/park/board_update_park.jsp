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
<link rel="stylesheet" href="<%=cp%>/board/css/created.css" type="text/css"/>

<script type="text/javascript" src="<%=cp%>/board/js/util.js"></script>


</head>

<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판
	</div>

	<form name="myForm" id="myForm" method="post" >
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				      <input type="text" name="board_subject" size="74" maxlength="100"
				      value="${info.board_subject}"  class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				      <input type="text" name="board_writer" size="35" maxlength="20"
				      value="${info.board_writer}" class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				      <input type="text" name="board_email" size="35" maxlength="50"
				      value="${info.board_email}"  class="boxTF" />
				</dd>
			</dl>
		</div>

		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				      <textarea name="board_content" cols="63" rows="12" class="boxTA">
				      ${info.board_content}
				      </textarea>
				</dd>
			</dl>
		</div>

		
	</div>

	<div id="bbsCreated_footer">
        <input type="button" value=" 수정하기 " class="btn2" onclick="board_update()"/>
        <input type="button" value=" 작성취소 " class="btn2" onclick="location.href='./board_list_park.do'"/>
	</div>

    </form>
</div>

</body>
<script type="text/javascript">
function board_update(){
	var my_form = document.getElementById('myForm');
	my_form.action = "./board_update_start_park.do";
	
	my_form.submit();
	
}
</script>


</html>