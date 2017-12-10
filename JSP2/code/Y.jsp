<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8" 
contentType="text/html;charset=UTF-8"%>
<!DOCTYPE  html>
<html  lang="zh-cn">
<head>
<title>Session Y</title>
</head>
<body>
  <h1>Session Y</h1>
  <p>session ID: <% out.print(session.getId()); %></p>
  <p>course: <% out.print(session.getAttribute("course") ); %></p>
  <p><a href="X.jsp">X.jsp</a></p>
  <p><a href="Z.jsp">Z.jsp</a></p>
</body>
</html>