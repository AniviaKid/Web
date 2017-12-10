<%@ page
	language="java"
	contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
%>
<%
	request.setCharacterEncoding("UTF-8");
	if(request.getParameter("exit")!=null) response.sendRedirect("http://www.baidu.com");
	//姓名
	String name = new String();
	String post_name = request.getParameter("name");
	if( post_name != null )
		name = post_name+"*";
	//密码
	String password = new String();
	String post_password = request.getParameter("password");
	if( post_password != null )
		password = post_password;
	//校区
	String checked_south = new String();
	String checked_east = new String();
	String checked_north = new String();
	String checked_zhuhai = new String();
	String checked_shenzhen = new String();
	String campus = request.getParameter("campus");
	if( campus != null )
	{
		if( campus.equals("south") )
			checked_south = "checked";
		if( campus.equals("east") )
			checked_east = "checked";
		if( campus.equals("north") )
			checked_north = "checked";
		if( campus.equals("zhuhai") )
			checked_zhuhai = "checked";
		if( campus.equals("shenzhen") )
			checked_shenzhen = "checked";
	}
	//年级
	String grade_one = new String();
	String grade_two = new String();
	String grade_three = new String();
	String grade_four = new String();
	String grade = request.getParameter("grade");
	if( grade != null )
	{
		if( grade.equals("freshman") )
			grade_one = "selected";
		if( grade.equals("sophomore") )
			grade_two = "selected";
		if( grade.equals("junior") )
			grade_three = "selected";
		if( grade.equals("senior") )
			grade_four = "selected";
	}
	//社团
	String checked_dance = new String();
	String checked_photo = new String();
	String checked_basketball = new String();
	String[] club = request.getParameterValues("club");
	if( club != null )
	{
		for( int i = 0; i < club.length; i++ )
		{
			if( club[i].equals("dance") )
				checked_dance = "checked";
			if( club[i].equals("photo") )
				checked_photo = "checked";
			if( club[i].equals("basketball") )
				checked_basketball = "checked";
		}
	}
	//说明
	String content = new String();
	String post_content = request.getParameter("content");
	if( post_content != null )
		content = post_content+"*";
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
	<form action="register3.jsp" method="post">
			<p>
			<label>同学名:</label> <input type="text" name="name" value=<%=name %>>
			</p>
			<p>
			<input type="hidden" name="id" value="1400001"/>
			<label>密码:</label> <input type="password" name="password" value=<%=password %>>
			</p>
			<p>
			校区:<input type="radio" name="campus" value="south" <%=checked_south %>>南校区
				<input type="radio" name="campus" value="east" <%=checked_east %>>东校区
				<input type="radio" name="campus" value="north" <%=checked_north %>>北校区
				<input type="radio" name="campus" value="zhuhai" <%=checked_zhuhai %>>珠海校区
				<input type="radio" name="campus" value="shenzhen" <%=checked_shenzhen %>>深圳校区
			</p>
			<p>
			年级：<select name="grade" >
				<option value="freshman" <%=grade_one %>>大学一年级</option>
				<option value="sophomore" <%=grade_two %>>大学二年级</option>
				<option value="junior" <%=grade_three %>>大学三年级</option>
				<option value="senior" <%=grade_four %>>大学四年级</option>
				</select>
			</p>
			<p>
			社团:<input type="checkbox" name="club" value="dance" <%=checked_dance %>>舞蹈队
					<input type="checkbox" name="club" value="photo" <%=checked_photo %>>摄影
					<input type="checkbox" name="club" value="basketball" <%=checked_basketball %>>篮球
			</p>
			<table border="0">
				<tr>
				<td valign="top">说明：</td>
				<td><textarea name="content" rows="6" cols="30"><%=content %></textarea></td>
				</tr>
			</table>
			<p>
				<input type="submit" name="save" value="保存">
				<input type="submit" name="exit" value="退出">
			</p>
	</form>
</html>