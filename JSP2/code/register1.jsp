<%@ page
	language="java"
	contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Register_Post</title>
	<style>
	   *{font-size:20px;font-family:宋体}
	   input[type="text"],textarea {color:#B0B0B0}
	   [for="content"]{vertical-align:top;}
	   fieldset {width:800px;margin:20px auto;padding:20px;background-color:#FCFCFF;}
	   #content {width:700px;height:300px}
	</style>
</head>
<body>
	<form action="register2.jsp" method="post">
			<p>
			<label>同学名:</label> <input type="text" name="name">
			</p>
			<p>
			<input type="hidden" name="id" value="15352427"/>
			<label>密码:</label> <input type="password" name="password">
			</p>
			<p>
			校区:<input type="radio" name="campus" value="south">南校区
				<input type="radio" name="campus" value="east">东校区
				<input type="radio" name="campus" value="north">北校区
				<input type="radio" name="campus" value="zhuhai">珠海校区
				<input type="radio" name="campus" value="shenzhen">深圳校区
			</p>
			<p>
			年级：<select name="grade" >
				<option value="freshman">大学一年级</option>
				<option value="sophomore">大学二年级</option>
				<option value="junior">大学三年级</option>
				<option value="senior">大学四年级</option>
				</select>
			</p>
			<p>
			社团:<input type="checkbox" name="club" value="dance">舞蹈队
					<input type="checkbox" name="club" value="photo">摄影
					<input type="checkbox" name="club" value="basketball">篮球
			</p>
			<table border="0">
				<tr>
				<td valign="top">说明：</td>
				<td><textarea name="content" rows="6" cols="30"></textarea></td>
				</tr>
			</table>
			<p>
				<input type="submit" name="save" value="保存">
				<input type="submit" name="exit" value="退出">
			</p>
	</form>
</html>