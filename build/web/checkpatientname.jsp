<%-- 
    Document   : checkusername
    Created on : Oct 13, 2015, 12:33:09 PM
    Author     : Raman Pandey
--%>

<%@ page import="java.io.*,java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
                    String sn=request.getParameter("ver");
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
                    Statement st=con.createStatement();
                    ResultSet rs = st.executeQuery("select * from patientdetails where patid='"+sn+"'");  // this is for name
                    while(rs.next())
                    {   
                        out.print(rs.getString("name"));
                    }
rs.close();
st.close();
con.close();
%>
