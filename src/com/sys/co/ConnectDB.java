package com.sys.co;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectDB 
{
	static Connection con = null;
	public static Connection connect()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/rentalsys_db", "root", "");
				System.out.println("Connected");
			}
			catch(Exception e) 
			{
			System.out.println("Something Went Wrong");
			e.printStackTrace();
			}
		}
		return con;
	}
}

