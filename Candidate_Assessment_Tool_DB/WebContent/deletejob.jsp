<%@ page import="com.company.services.*"%>
<%@ page import="java.sql.*" %>

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
			int jid = Integer.parseInt(request.getParameter("jid"));
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("delete from job where jid = ?");
			ps.setInt(1, jid);
			int i = ps.executeUpdate();
			
			PreparedStatement ps17 = con.prepareStatement("delete from candidate where jid = ?");
			ps17.setInt(1, jid);
			ps17.executeUpdate();
			
			PreparedStatement ps18 = con.prepareStatement("delete from assignjobs where jid = ?");
			ps18.setInt(1, jid);
			ps18.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("viewjob.jsp");
			}
			else
			{
				response.sendRedirect("viewjob.jsp");
			}
			
		%>
</body>
</html>