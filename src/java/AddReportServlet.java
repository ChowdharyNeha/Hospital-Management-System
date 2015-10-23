

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/AddReportServlet")
  // 100 MB
public class AddReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// gets absolute path of the web application
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
			Statement stmt = con.createStatement();
			
	        //Get all the parts from request and write it to the file on server
	        //String fname = getFileName(request.getPart("fname"));
	        String patId = request.getParameter("patient_id");
                String docId = request.getParameter("doc_id");
	        String patientName = request.getParameter("patient_name");
	        String doctorName = request.getParameter("doc_name");
	        String disease = request.getParameter("disease");
	        String fees = request.getParameter("fees");
	        String dosage = request.getParameter("dosage");
	        String medicine = request.getParameter("medicine");
                String prescription = request.getParameter("prescription");
	        //request.setAttribute("docphoto", fileName);
	        //request.setAttribute("docid", docId);
	        //request.setAttribute("docname", docName);
	        //request.setAttribute("specialization", specialization);
	        //request.setAttribute("department", department);
	        //request.setAttribute("timing", timing);
	        //request.setAttribute("fees", fees);
	        //request.setAttribute("emailId", emailId);
	        //getServletContext().getRequestDispatcher("/r.jsp").forward(request, response);
	        String query = "insert into reports values('"+patId+"','"+patientName+"','"+doctorName+"','"+disease+"','"+fees+"','"+dosage+"','"+medicine+"','"+prescription+"','"+docId+"')";
	        stmt.executeUpdate(query);
	        stmt.close();
	        con.close();
	        out.print("Inserted!!!!");
	        response.sendRedirect("reports.jsp");
	        
	}   catch (ClassNotFoundException ex) {
                Logger.getLogger(PatientDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PatientDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
                //.print("Data is not Inserted");
            }
        }

    }
