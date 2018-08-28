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
<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function check() {
		var id = loginForm.user_id.value;
		var pass = loginForm.user_pw.value;

		if (id.length == 0) {
			alert("아이디를 입력하세요.");
			loginForm.user_id.focus();
			return false;
		}
		if (pass.length == 0) {
			alert("비밀번호를 입력하세요.");
			loginForm.user_pw.focus();
			return false;
		}

		return true;
	}
</script>
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
							<form action="./loginCheckt.uo" name="loginForm" method="post"
								class="text-center" onsubmit="return check()">
								<div class="form-group text-left">
									<label>아이디</label> <input type="text" class="form-control"
										name="user_id" placeholder="Enter ID">
								</div>
								<div class="form-group text-left">
									<label>비밀번호</label> <input type="password" class="form-control"
										name="user_pw" placeholder="Password">
								</div>
								<br>
								<button type="submit" class="btn btn-primary btn-block">로그인</button>
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
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>

</html>