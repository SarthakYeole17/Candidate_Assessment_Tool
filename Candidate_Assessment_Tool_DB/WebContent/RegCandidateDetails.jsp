<%@ page import="java.sql.*" %>
<%@ page import="com.company.services.*" %>
<%@ page import="com.company.test.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try
		{
			Connection con = ConnectDB.getConnect();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String mobile = request.getParameter("mobile");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String education = request.getParameter("education");
			TempUserData.setEmail(email);
			PreparedStatement ps = con.prepareStatement("INSERT INTO candidate VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, mobile);
			ps.setInt(5, age);
			ps.setString(6, email);
			ps.setString(7, education);
			ps.setString(8, "-");
			
			ps.setString(9, "-");
			ps.setString(10, "-");
			ps.setString(11, "-");
			ps.setString(12, "-");
			ps.setString(13, "-");
			ps.setString(14, "-");
			ps.setString(15, "-");
			ps.setString(16, "-");
			ps.setString(17, "-");
			ps.setString(18, "-");
			ps.setString(19, "-");
			ps.setString(20, "-");
			ps.setString(21, "-");
			ps.setString(22, "-");
			ps.setString(23, "-");
			ps.setString(24, "-");
			ps.setString(25, "-");
			ps.setString(26, "-");
			ps.setString(27, "-");
			ps.setString(28, "-");
			ps.setString(29, "-");
			ps.setString(30, "-");
			ps.setString(31, "-");
			ps.setString(32, "-");
			ps.setString(33, "-");
			ps.setInt(34, TempUserData.getJid());

			
			int i = ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("canditest.html");
			}
			else
			{
				response.sendRedirect("registCandi.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
%>
</body>
</html>