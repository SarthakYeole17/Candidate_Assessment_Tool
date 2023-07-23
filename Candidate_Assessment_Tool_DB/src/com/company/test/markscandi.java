package com.company.test;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.services.ConnectDB;
//import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class markscandi
 */
public class markscandi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public markscandi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int o=0;
		int c=0;
		int e=0;
		int a=0;
		int n=0;
		
		try
		{
			Connection con = ConnectDB.getConnect();
			
			PreparedStatement ps = con.prepareStatement("select * from candidate where email = ?");
			ps.setString(1, TempUserData.getEmail());
			ResultSet rs = ps.executeQuery();
			
			PreparedStatement ps1 = con.prepareStatement("select * from test");
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs.next())
			{
				int i = 9;
				while(rs1.next())
				{
					String demo = rs.getString(i);
					if(demo.equals(rs1.getString(3)))
					{
						o=o+1;
					}
					else if(demo.equals(rs1.getString(4)))
					{
						c=c+1;
					}
					else if(demo.equals(rs1.getString(5)))
					{
						e=e+1;
					}
					else if(demo.equals(rs1.getString(6)))
					{
						a=a+1;
					}
					else if(demo.equals(rs1.getString(7)))
					{
						n=n+1;
					}
					i++;
				}
			}
			
			if(o>c && o>e && o>a && o>n)
			{
				try
				{
					System.out.println("Start");
					 Connection con1 = ConnectDB.getConnect();
					 PreparedStatement ps2 = con1.prepareStatement("update candidate set qualities = ? where email = ?");
					 ps2.setString(1, "o");
					 ps2.setString(2, TempUserData.getEmail());
					 
					 int i = ps2.executeUpdate();
					 
					 
					 if(i>0)
					 {
						 response.sendRedirect("ResponseSubmitted.html");
					 }
					 else
					 {
						 response.sendRedirect("ResponseFailed.html");
					 }
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			else if(c>e && c>a && c>n)
			{
				try
				{
					 Connection con2 = ConnectDB.getConnect();
					 PreparedStatement ps3 = con2.prepareStatement("update candidate set qualities = ? where email = ?");
					 ps3.setString(1, "c");
					 ps3.setString(2, TempUserData.getEmail());
					 
					 System.out.println("c up");


					 int i = ps3.executeUpdate();

						System.out.println("c update");
					 if(i>0)
					 {
						 response.sendRedirect("ResponseSubmitted.html");
					 }
					 else
					 {
						 response.sendRedirect("ResponseFailed.html");
					 }
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
			else if(e>a && e>n)
			{
				try
				{
					 Connection con3 = ConnectDB.getConnect();
					 PreparedStatement ps4 = con3.prepareStatement("update candidate set qualities = ? where email = ?");
					 ps4.setString(1, "e");
					 ps4.setString(2, TempUserData.getEmail());
					 
					 System.out.println("e up");


					 int i = ps4.executeUpdate();

						System.out.println("e update");
					 if(i>0)
					 {
						 response.sendRedirect("ResponseSubmitted.html");
					 }
					 else
					 {
						 response.sendRedirect("ResponseFailed.html");
					 }
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
			else if(a>n)
			{
				try
				{
					 Connection con4 = ConnectDB.getConnect();
					 PreparedStatement ps5 = con4.prepareStatement("update candidate set qualities = ? where email = ?");
					 ps5.setString(1, "a");
					 ps5.setString(2, TempUserData.getEmail());
					 
					 System.out.println("a up");


					 int i = ps5.executeUpdate();

						System.out.println("a update");
					 if(i>0)
					 {
						 response.sendRedirect("ResponseSubmitted.html");
					 }
					 else
					 {
						 response.sendRedirect("ResponseFailed.html");
					 }
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
			else
			{
				try
				{
					 Connection con5 = ConnectDB.getConnect();
					 PreparedStatement ps6 = con5.prepareStatement("update candidate set qualities = ? where email = ?");
					 ps6.setString(1, "n");
					 ps6.setString(2, TempUserData.getEmail());
					 
					 System.out.println("n up");


					 int i = ps6.executeUpdate();

						System.out.println("n update");
					 if(i>0)
					 {
						 response.sendRedirect("ResponseSubmitted.html");
					 }
					 else
					 {
						 response.sendRedirect("ResponseFailed.html");
					 }
					 
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		
	}
}
	
	



