<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>登录页</title>

<!-- Bootstrap core CSS -->
<link href="../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="../js/jquery-2.1.4.min.js"></script>
</head>

<body>

	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputEmail" class="sr-only">用户名</label> <input
				type="text" id="inputUsername" class="form-control"
				placeholder="用户名" required autofocus> <label
				for="inputPassword" class="sr-only">密码</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="密码" required>
			<div class="checkbox">
				<!--      <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label> -->
			</div>
			<button id="login" class="btn btn-lg btn-primary btn-block"
				type="submit">登录</button>		
		</form>

	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
<script>
$(document).ready(function(){
		$("#login").click(function() {
			var username = $('#inputUsername').val();
	    	var password = $('#inputPassword').val();
	    	window.location.href = "../main/loginin.do?username="+username+"&password="+password;
	    	return false;
		});
});

</script>
</html>
