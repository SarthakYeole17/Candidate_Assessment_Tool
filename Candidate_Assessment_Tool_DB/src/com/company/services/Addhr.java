package com.company.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.services.*;

/**
 * Servlet implementation class Addhr
 */
public class Addhr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addhr() {
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
		
		try
		{
			Connection con = ConnectDB.getConnect();
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String mobile = request.getParameter("mobile");
			String designation = request.getParameter("designation");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO `hr`(`hid`, `fname`, `lname`, `mobile`, `designation`, `email`, `password`) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, mobile);
			ps.setString(5, designation);
			ps.setString(6, email);
			ps.setString(7, password);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("hrsuccess.html");
			}
			else
			{
				response.sendRedirect("addhrForm.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
