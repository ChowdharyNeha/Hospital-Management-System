<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
String doctorId = request.getParameter("doctor_id");

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms","root","");
Statement stmt = con.createStatement();
String Query = "DELETE FROM doctordetails WHERE docid ='"+doctorId+"'";
out.print(Query);
int i =stmt.executeUpdate(Query);
if(i>0)
	out.print("Deleted!");
con.close();
response.sendRedirect("doctordetails.jsp");
%>
</body>
</html>