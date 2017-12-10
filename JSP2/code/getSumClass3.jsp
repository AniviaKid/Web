<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>getAddClass3</title>
</head>
<body>
<h1>getAddClass3</h1>
	<jsp:useBean id="add" scope="page" class="com.group.bean.Add" />
	<jsp:setProperty name="add" property="numA" value="35"/>
	<jsp:setProperty name="add" property="numB" value="45"/>
	<jsp:setProperty name="add" property="numC" value="55"/>
	<jsp:getProperty name="add" property="sum"/>
</body>
</html>