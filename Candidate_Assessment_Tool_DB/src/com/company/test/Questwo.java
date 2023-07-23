package com.company.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.services.ConnectDB;

/**
 * Servlet implementation class Questwo
 */
public class Questwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Questwo() {
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
		
		String highlyagree = request.getParameter("highlyagree");
		String agree = request.getParameter("agree");
		String neutral = request.getParameter("neutral");
		String disagree = request.getParameter("disagree");
		String highlydisagree = request.getParameter("highlydisagree");
		
		if(highlyagree != null)
		{
			String ha = "highlyagree";
			try
			{
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("update candidate set qtwo =? where email=?");
				ps1.setString(1, ha);
				ps1.setString(2, TempUserData.getEmail());
				ps1.executeUpdate();
				int i = ps1.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("ques3.html");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(agree!=null)
		{
			String ha = "agree";
			try
			{
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("update candidate set qtwo =? where email=?");
				ps1.setString(1, ha);
				ps1.setString(2, TempUserData.getEmail());
				ps1.executeUpdate();
				int i = ps1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("ques3.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(neutral!=null)
		{
			String ha = "neutral";
			try
			{
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("update candidate set qtwo =? where email=?");
				ps1.setString(1, ha);
				ps1.setString(2, TempUserData.getEmail());
				ps1.executeUpdate();
				int i = ps1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("ques3.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(disagree!=null)
		{
			String ha = "disagree";
			try
			{
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("update candidate set qtwo =? where email=?");
				ps1.setString(1, ha);
				ps1.setString(2, TempUserData.getEmail());
				ps1.executeUpdate();
				int i = ps1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("ques3.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		else if(highlydisagree!=null)
		{
			String ha = "highlydisagree";
			try
			{
				Connection con = ConnectDB.getConnect();
				PreparedStatement ps1 = con.prepareStatement("update candidate set qtwo =? where email=?");
				ps1.setString(1, ha);
				ps1.setString(2, TempUserData.getEmail());
				ps1.executeUpdate();
				int i = ps1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("ques3.html");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}

}
