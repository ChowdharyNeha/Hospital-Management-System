<%@ page import="java.io.*" %>
<%

String uname = request.getParameter("adminUname");
String passwd = request.getParameter("adminUpass");

if(uname.equals("admin") && passwd.equals("admin123"))
{
	session.setAttribute("username",uname);
	response.sendRedirect("dashboard.jsp");
}
else
{
	out.print("Username and Password are not valid!");
}

%>