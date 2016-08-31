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
    <link href="../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

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

          <div class="row placeholders">



          <h2 class="sub-header">图片管理</h2>
          <div style="margin:0;width:0px;"> 
          <button id="upload" type="button" class="btn btn-sm btn-default">图片上传</button>
          </div>
          <div class="table-responsive">
            <table class="table table-striped">
             
              <thead>
                <tr>
                  <th>id</th>
                  <th>文件名</th>
                  <th>图片大小</th>
                  <th>创建时间</th>
                  <th>缩略图</th>
                  <th>操作</th>
                </tr>
              </thead>
              <c:forEach items="${imagelist}" var="imagelist">
              <tbody>
                <tr>
                  <td>${imagelist.id}</td>
                  <td>${imagelist.fileName}</td>
                  <td>${imagelist.fileSize}</td>
                  <td>${imagelist.createTime}</td>
                  <td>
                      <img src="../image/uploadfile/003.jpg">
                  </td>
                  <td>sit</td>
                </tr>           
              </tbody>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../js/jquery-2.1.4.min.js"></script>
    <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
<script type="text/javascript">
$(document).ready(function(){
	$("#upload").click(function(){
		window.location.href = "../manage/upload.do"; 
	});
});
</script>
</html>
    