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
String patientId = request.getParameter("patient_id");
String updateOpt = request.getParameter("opt_change");
String newVal = request.getParameter("new_val");

out.println(patientId);
out.println(updateOpt);
out.println(newVal);

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hms","root","");
Statement stmt = con.createStatement();
String Query = "UPDATE reports SET " + updateOpt +" = '"+newVal+"' WHERE patid='"+patientId+"'";
out.print(Query);
int i =stmt.executeUpdate(Query);
if(i>0)
	out.print("Updated!");
con.close();
response.sendRedirect("reports.jsp");

%>
</body>
</html>