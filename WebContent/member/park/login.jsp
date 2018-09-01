<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-beta.1.css"
	type="text/css">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>


</head>

<body>

	

	<div class="py-5 bg-warning">
		<div class="container">
		<br><br><br><br><br>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card text-white p-5 bg-dark">
						<div class="card-body bg-dark">
							<h1 class="mb-4 text-center">Login</h1>
							<form  name="loginForm"  method="post"
								class="text-center"  id="loginForm">
								<div class="form-group text-left">
									<label>아이디</label> <input type="text" class="form-control"
										name="member_id" placeholder="Enter ID" id="user_id">
								</div>
								<div class="form-group text-left">
									<label>비밀번호</label> <input type="password" class="form-control"
										name="member_pass" placeholder="Password">
								</div>
								<br>
								<button type="button" class="btn btn-primary btn-block" onclick="check()">로그인</button>
							</form>
							<br> <a class="btn btn-primary btn-block"
								href="./register.do">회원가입 </a>

						</div>
					</div>
				</div>
			</div>
		</div>
		<br><br><br><br><br>	
	</div>
	
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
	function check() {
		var id = loginForm.member_id.value;
		var pass = loginForm.member_pass.value;
	
		if (id.length == 0) {
			alert("아이디를 입력하세요.");
			loginForm.member_id.focus();
			return false;
		}
		if (pass.length == 0) {
			alert("비밀번호를 입력하세요.");
			loginForm.member_pass.focus();
			return false;
		}
	
	
		$.ajax(
				{
					url : "./login_check.do",
	                data: $('#loginForm').serializeArray(),
					type: 'Post',
					dataType : 'text',
					success : function(result) {
						
						
					
						if(result==0){
							alert('아이디와 비밀번호가 일치하지 않습니다.')
							return false;
						}else{
							location.href='./././board_list_park.do';
								
						}
						
						
						
					},
					error : function() {
						alert('통신실패');
					}
				})
		
		
		
	}
	

</script>
</html>