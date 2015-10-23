<%
session.setAttribute("userid",null);
session.invalidate();
response.sendRedirect("dashboard.jsp");
%>