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
<script type="text/javascript">

    function sendIt() {
       
		f = document.myForm;

    /* 	str = f.subject.value;
    	str = str.trim();
        if(!str) {
            alert("\n제목을 입력하세요. ");
            f.subject.focus();
            return;
        }
    	f.subject.value = str;

	    str = f.name.value;
    	str = str.trim();
        if(!str) {
            alert("\n이름을 입력하세요. ");
            f.name.focus();
            return;
        }
		
        if(!isValidKorean(str))  {
            alert("\n이름을 정확히 입력하세요");
            f.name.focus();
            return;
        }
		
	    f.name.value = str;

        if(f.email.value) {
	    	if(!isValidEmail(f.email.value)) {
                alert("\n정상적인 E-Mail을 입력하세요. ");
                f.email.focus();
                return;
	    	}
        }

    	str = f.content.value;
	    str = str.trim();
        if(!str) {
            alert("내용을 입력하세요. ");
            f.content.focus();
            return;
        }
    	f.content.value = str; */
    	
        f.action = "<%=cp%>/bbs/m_created_ok.do";
        f.submit();
    }

</script>

</head>

<body>

<div id="bbs">
	<div id="bbs_title">
	게 시 판 (Servlet)
	</div>

	<form name="myForm" method="post" action="">
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				      <input type="text" name="boardSubject_kmk" size="74" maxlength="100"  class="boxTF" />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				      <input type="text" name="userId_kmk" size="35" maxlength="20" class="boxTF"
				       />
				</dd>
			</dl>
		</div>

		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				      <input type="text" name="userEmail_kmk" size="35" maxlength="50" class="boxTF" />
				</dd>
			</dl>
		</div>

		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				      <textarea name="boardContent_kmk" cols="63" rows="12" class="boxTA"></textarea>
				</dd>
			</dl>
		</div>

	</div>

	<div id="bbsCreated_footer">
        <input type="button" value=" 등록하기 " class="btn2" 
        onclick="sendIt();"/>
        <input type="reset" value=" 다시입력 " class="btn2" 
        onclick="document.myForm.boardSubject_kmk.focus();"/>
        <input type="button" value=" 작성취소 " class="btn2" 
        onclick="javascript:location.href='<%=cp%>/main.jsp';"/>
	</div>

    </form>
</div>

</body>

</html>