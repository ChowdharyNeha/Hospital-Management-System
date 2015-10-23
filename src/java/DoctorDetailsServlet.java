
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
@WebServlet("/DoctorDetailsServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
				maxFileSize=1024*1024*50,          // 50 MB
				maxRequestSize=1024*1024*100)      // 100 MB
public class DoctorDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static final String UPLOAD_DIR = "uploads";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// gets absolute path of the web application
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
			Statement stmt = con.createStatement();
				
	        String applicationPath = request.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file
	        //String uploadFilePath = "E:/images/";
	        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        System.out.println(request);
	          
	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	         
	        String fileName = getFileName(request.getPart("fileName"));
	        Part part = request.getPart("fileName");
	        part.write(uploadFilePath + File.separator + fileName);
	        //Get all the parts from request and write it to the file on server
	        //String fname = getFileName(request.getPart("fname"));
	        String docId = request.getParameter("doctor_id");
	        String docName = request.getParameter("doc_name");
	        String specialization = request.getParameter("specialization");
	        String department = request.getParameter("department");
	        String timing = request.getParameter("timing");
	        String fees = request.getParameter("fees");
	        String emailId = request.getParameter("email_id");
	        request.setAttribute("docphoto", fileName);
	        request.setAttribute("docid", docId);
	        request.setAttribute("docname", docName);
	        request.setAttribute("specialization", specialization);
	        request.setAttribute("department", department);
	        request.setAttribute("timing", timing);
	        request.setAttribute("fees", fees);
	        request.setAttribute("emailId", emailId);
	        //getServletContext().getRequestDispatcher("/r.jsp").forward(request, response);
	        String query = "insert into doctordetails values('"+docId+"','"+docName+"','"+specialization+"','"+department+"','"+fileName+"','"+timing+"','"+fees+"','"+emailId+"')";
	        stmt.executeUpdate(query);
	        stmt.close();
	        con.close();
	        out.print("Inserted!!!!");
	        response.sendRedirect("doctordetails.jsp");
	        
	}   catch (ClassNotFoundException ex) { 
                Logger.getLogger(DoctorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
	}
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

}
