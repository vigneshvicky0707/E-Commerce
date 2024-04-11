

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String al = request.getParameter("n1");
		String bl = request.getParameter("n2");
		PrintWriter pw = response.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshopper","root","Gowri@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from reg where email='"+al+"'and password='"+bl+"' ");
			if(rs.next())
			{
				String c = rs.getString(1);
				HttpSession s = request.getSession();
				s.setAttribute("abc",c);
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception e){
			pw.println(e);
			
		}
		
	}

}
