<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<title>图片管理</title>

<!-- Bootstrap core CSS -->
<link href="../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<jsp:include page="../htm/part/head.html" flush="true" />

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="../htm/part/left.html" flush="true" />

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>你好</h1>
					<p>欢迎页制作中</p>
				</div>

				<div class="row">
					<div class="col-xs-6 col-lg-4">
						<h2>图片管理</h2>
						<p>管理服务器中的图片</p>
						<p>
							<a class="btn btn-default" id="image" role="button">查看详情
								&raquo;</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div>
				<!--/row-->
				<hr>

				<footer>
					<p>&copy; 2016 Company, Inc.</p>
				</footer>
			</div>

		</div>

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="../js/jquery-2.1.4.min.js"></script>
		<script>
			window.jQuery
					|| document
							.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>')
		</script>
		<script src="../dist/js/bootstrap.min.js"></script>
		<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
		<script src="../assets/js/vendor/holder.min.js"></script>
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#image").click(function() {
			viewinfo("image");
		});
	});
	function viewinfo(type) {
		urlpath = "../manage/" + type + ".do";
		window.location.href = urlpath;
	}
</script>
</html>
