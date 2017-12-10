<%@ page
	language="java"
	contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>实现文件上传</title>
</head>
<body>
	<p>实现文件上传</p>
	<form name="fileupload" action="fileUpload.jsp" method="POST" enctype="multipart/form-data">
		<p>id：<input type="text" name="name" size=24></p>
		<p>文件：<input type="file" name="file" size=24></p>
		<p><input type=submit name="submit" value="OK"></p>
	</form>
</body>
</html>
