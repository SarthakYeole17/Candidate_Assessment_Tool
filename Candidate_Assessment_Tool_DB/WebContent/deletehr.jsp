<%@ page import="com.company.services.*"%>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete HR</title>
</head>
<body>

		<%
			int hid = Integer.parseInt(request.getParameter("hid"));
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("delete from hr where hid = ?");
			ps.setInt(1, hid);
			int i = ps.executeUpdate();
			
			/*
			PreparedStatement ps17 = con.prepareStatement("delete from job where hid = ?");
			ps17.setInt(1, hid);
			ps17.executeUpdate();
			*/
			
			//int jid;
			//PreparedStatement ps = con.prepareStatement("select * from job where hid = ?");
			
			
			if(i>0)
			{
				response.sendRedirect("admdeletehr.jsp");
			}
			else
			{
				response.sendRedirect("viewhr.jsp");
			}
			
		%>
</body>
</html>