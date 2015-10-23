<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String UPLOAD_DIR = "uploads";
	String applicationPath = request.getServletContext().getRealPath("");
	String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
	Statement stmt = con.createStatement();
	String query = "Select * from doctordetails";
	ResultSet rs = stmt.executeQuery(query);
	while(rs.next()){
		String filename = rs.getString(5);
		String name = rs.getString(2);
		//out.print(filename);
		//out.print(name);
		String imgPath = uploadFilePath+"/"+filename;
		//out.print(imgPath);
		File imgfile = new File(imgPath);
		%>
		<img src="<%=request.getContextPath()%>/uploads/<%=filename%>"/>
		<%
	}
	stmt.close();
	con.close();
	
%>	
</body>
</html>