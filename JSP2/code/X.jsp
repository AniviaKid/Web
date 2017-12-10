<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8" 
contentType="text/html;charset=UTF-8"%>
<%
	session.setAttribute("course", "移动Web应用设计"+"---"+(new Date()).toString());
%>
<!DOCTYPE  html>
<html  lang="zh-cn">
<head>
<title>Session X</title>
</head>
<body>
  <h1>Session X</h1>
  <p>session ID: <% out.print(session.getId()); %></p>
  <p><a href="Y.jsp">Y.jsp</a></p>
  <p><a href="Z.jsp">Z.jsp</a></p>
</body>
</html>