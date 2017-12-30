<%@ page language="java" import="java.util.*,java.sql.*" 
         contentType="text/html; charset=utf-8"
%><%request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String connectString = "jdbc:mysql://172.18.187.233:53306/teaching"
	        + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&&useSSL=false";
	String user = "user";
	String pass = "123";
	Connection conn = DriverManager.getConnection(connectString, user, pass);
	String sql = "update stu set name = ? where id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, id);
	int count = pstmt.executeUpdate();
	String result;
	if(count > 0) {
		result = "修改成功";
	} else {
		result = "无此人";
	}
	response.getWriter().write(result);
	response.flushBuffer();
%>



