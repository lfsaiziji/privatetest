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

    <title>文件上传</title>

    <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/sticky-footer.css" rel="stylesheet">

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

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>图片上传</h1>
      </div>
      <input id="fileToUpload" type="file" size="45" name="fileToUpload"
		class="input">
		<button class="button" onclick="ajaxFileUpload()">上传</button>
      	<br>
      	<button class="button" onclick="test()">测试</button>
      	<br>
	<img id="viewImg" src='file:///F:/up/save/1472634148050.jpg'>
    </div>

    <footer class="footer">
      <div class="container">
        <p class="text-muted"></p>
      </div>
    </footer>
   

 


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
  </body>
<script type="text/javascript">
function test(){
	$('#viewImg').attr('src','../image/uploadfile/1472634352934.jpg');
}
function showimage(path){
	$('#viewImg').attr('src',path);
}

function ajaxFileUpload() {
	$.ajaxFileUpload({
		url : '../manage/uploadfile.do',
		secureuri : false,
		fileElementId : 'fileToUpload',
		dataType : 'json',
		success : function(data) {
			alert(data.thumpath);
			showimage(data.thumpath);
		},
		error : function(data, status, e) {
			alert('上传出错');
		}
	})

	return false;

}
</script>
</html>
    