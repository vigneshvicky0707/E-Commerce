<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.view-box
{
border:2px solid gray;
padding:5px;
width: 220px;
}
.view1-box
{
text-align:center;

}

</style>
</head>
<body>
<%
String a = request.getParameter("b");
String b = session.getAttribute("abc").toString();


						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshopper","root","Gowri@123");
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("select * from product where pid='"+a+"' ");
							while(rs.next())
							{%>
							
							<div class="view-box">
							<div class= "view1-box">
							<img src ="<%=rs.getString(4)%>" width="200px" heigth="200px"><br>
							<h3><%=rs.getString(2)%></h3>
							<h5><%=rs.getString(3)%></h5>
							
							
							</div>
							</div>	
							<%}
							
						}
						catch(Exception e)
						{
							out.println(e);
						}
						%>
						
<form>
<h3> Order Address </h3>
<form action="#" method="post">

pid<input type = "text" value="<%=a%>"><br><br>
Name<input tyoe="text" value = "<%=b%>"><br><br>
Address<input type="text" name="n1"><br><br>
Phone no <input type="text" name="n2"><br><br>
<input type="submit">

</form>

</form>						
	<%
	String x= request.getParameter("n1");
	String y =request.getParameter("n2");
	if(x!=null && y!=null)
	{
	try
	{
		if(x!=null && y!=null)
		
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshopper","root","Gowri@123");
		Statement st = con.createStatement();
		st.executeUpdate("insert into order1 values('"+a+"','"+b+"','"+x+"','"+y+"')");
		out.println("<script>alert('order successfully');</script>");
		
	}
	catch(Exception e)
	{
		out.println(e);
	}
	}
	
	
	
	
	
	
	
	%>					
						
					
</body>
</html>