package com.company.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.test.TempUserData;

/**
 * Servlet implementation class CandidateRegt
 */
public class CandidateRegt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateRegt() {
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
			ps.setInt(34, 2);

			
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
	}

}
