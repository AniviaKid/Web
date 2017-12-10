<%@ page
	language="java"	
	contentType="text/html; UTF-8"
    pageEncoding="UTF-8"
%>
<%
	request.setCharacterEncoding("UTF-8");
	if(request.getParameter("exit")!=null) response.sendRedirect("http://www.baidu.com");
	String[] club = request.getParameterValues("club");
	String club_message = new String("[");
	for( int i = 0; i < club.length-1; i++ )
		club_message += club[i]+", ";
	club_message += club[club.length-1]+"]";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>postShow</title>
</head>
<body>
	<p>id: <%=request.getParameter("id") %></p>
	<p>同学名: <%=request.getParameter("name") %></p>
	<p>密码: <%=request.getParameter("password") %></p>
	<p>校区: <%=request.getParameter("campus") %></p>
	<p>社团: <%=club_message %></p>
	<p>年级: <%=request.getParameter("grade") %></p>
	<p>说明: <%=request.getParameter("content") %></p>
	<p>submit1:<%=request.getParameter("save") %></p>
	<p>submit2:<%=request.getParameter("exit") %></p>
</body>
</html>