<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.mobile-1.4.5.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="content">hello world<div>
<input type="hidden" id="hidden_info">
<input type="hidden" id="hidden_info2">

<script type="text/javascript">

	function exec(){
		ajax(id)
	}
	
	function ajax(id){
		  $('#hidden_info2').val('1');
	}

	
	
	
</script>
<script type="text/javascript">
$(function(){
  $('.content').click(function(){
    $('.content').hide();
  });
});
</script>
</body>


</html>