

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ar = request.getParameter("n1");
		String br = request.getParameter("n2");
		String cr = request.getParameter("n3");
		PrintWriter pw = response.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshopper","root","Gowri@123");
			Statement st = con.createStatement();
			st.executeUpdate("insert into reg values('"+ar+"','"+br+"','"+cr+"')");
			pw.println("<script>alert('success');</script>");
			response.sendRedirect("adminlogin.jsp");
		}
		catch(Exception e){
			pw.println(e);
			
		}
	}

}
