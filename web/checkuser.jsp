<% 
String name= request.getParameter("uname");
String pwd = request.getParameter("upass");
	if(name.equals("user1") && pwd.equals("pass1") && session.getAttribute("sesval").equals("mainpage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("main.jsp");
		}
	else if(name.equals("user2") && pwd.equals("pass2") && session.getAttribute("sesval").equals("accountspage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("accounts.jsp");
		}
	else if(name.equals("user3") && pwd.equals("pass3") && session.getAttribute("sesval").equals("inventorypage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("inventory.jsp");
		}
	else if(name.equals("user4") && pwd.equals("pass4") && session.getAttribute("sesval").equals("payrollpage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("payroll.jsp");
		}
	else if(name.equals("user5") && pwd.equals("pass5") && session.getAttribute("sesval").equals("masterpage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("master.jsp");
		}
	else if(name.equals("user6") && pwd.equals("pass6") && session.getAttribute("sesval").equals("reportspage"))
		{
			session.setAttribute("userid",name);
			response.sendRedirect("reports.jsp");
		}
	else
		response.sendRedirect("dashboard.jsp");
%>