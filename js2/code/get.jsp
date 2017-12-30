<%@ page language="java" import="java.util.*,java.sql.*" 
         contentType="text/html; charset=utf-8"
%><%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String connectString = "jdbc:mysql://172.18.187.233:53306/teaching"
	        + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&&useSSL=false";
	String user = "user";
	String pass = "123";
	Connection conn = DriverManager.getConnection(connectString, user, pass);
	String sql = "select * from stu where id = ?";
	//String sql = "select * from stu";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	String result;
	if(rs.next()){
		//String tmp=rs.getString("id");
		String num = rs.getString("num");
		String name = rs.getString("name");
		result = "id: " + id + "<br>\n" + "num: " + num + "<br>\n" + "name: " + name + "<br>\n";
	} else {
		result = "查无此人";
	}
	response.getWriter().write(result);
	response.flushBuffer();
%>
