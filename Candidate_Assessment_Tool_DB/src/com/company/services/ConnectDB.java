package com.company.services;

import java.sql.*;

public class ConnectDB 
{
	static Connection con = null;
	public static Connection getConnect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/candidate_assessment_tool_database","root","");
			if(con==null)
			{
				System.out.println("Connection Failed!!!");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
