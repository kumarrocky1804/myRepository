package com.hibernateDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest 
{
	public static void main(String[] args) {
		Connection con=null;
		try {			
			String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
			String user = "root";
			String password = "Rocky@1804";
			
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connected");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
