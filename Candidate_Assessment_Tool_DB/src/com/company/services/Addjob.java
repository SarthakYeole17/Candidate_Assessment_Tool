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
 * Servlet implementation class Addjob
 */
public class Addjob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addjob() {
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
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String  salaryrange = request.getParameter("salaryrange");
			String qualities = request.getParameter("qualities");
			String experience = request.getParameter("experience");
			
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO job VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setInt(2, TempUserData.getHid());
			ps.setString(3, title);
			ps.setString(4, description);
			ps.setString(5, salaryrange);
			ps.setString(6, qualities);
			ps.setString(7, experience);
			
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("avdJobHr.html");
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
