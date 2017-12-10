<%@ page
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	import="java.io.*,java.util.*,org.apache.commons.io.*"
	import="org.apache.commons.fileupload.*"
	import="org.apache.commons.fileupload.disk.*"
	import="org.apache.commons.fileupload.servlet.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文件传输例子</title>
</head>
<body>
<div>
<% request.setCharacterEncoding("utf-8"); %>
<%
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);//检查表单中是否包含文件
	if(isMultipart) {
		FileItemFactory factory = new DiskFileItemFactory();
		//factory.setSizeThreshold(yourMaxMemorySize); //设置使用的内存最大值
		//factory.setRepository(yourTempDirectory); //设置文件临时目录
		ServletFileUpload upload = new ServletFileUpload(factory);
		//upload.setSizeMax(yourMaxRequestSize); //允许的最大文件尺寸
		List items = upload.parseRequest(request);
		for(int i = 0; i < items.size(); i++) {
			FileItem fi = (FileItem) items.get(i);
			if(fi.isFormField()) {//如果是表单字段
				//out.print("<p>"+fi.getFieldName()+":"+fi.getString("UTF-8")+"</p>");
			}
			else{//如果是文件
				DiskFileItem dfi = (DiskFileItem) fi;
				if(!dfi.getName().trim().equals("")) {//getName()返回文件名称或空串
					out.print("<p>文件被上传到服务上的实际位置：");
					String filePath = application.getRealPath("/file") + System.getProperty("file.separator");
					File file = new File(filePath);
					if(!file.exists())
						file.mkdir();
					String fileName = filePath + FilenameUtils.getName(dfi.getName());
					out.print(new File(fileName).getAbsolutePath()+"</p>");
					dfi.write(new File(fileName));
					out.write("<p><a href=\"./file/"+FilenameUtils.getName(dfi.getName())+"\">"+FilenameUtils.getName(dfi.getName())+"</a></p>");
				}
			} //if
		} //for
	} //if
%>
</div>
</body>
</html>