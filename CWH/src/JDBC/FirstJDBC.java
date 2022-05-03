package JDBC;

import java.sql.*;

public class FirstJDBC 
{
	public static void main(String[] args) {
		
		try {
			// it is deprecated
			//Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "Rocky@1804";
			String query = "Select * from Students";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			// Prepare Statement
			/*PreparedStatement ps = con.prepareStatement("INSERT INTO Students VALUES (?,?,?,?,?)");
			ps.setInt(1, 3);
			ps.setString(2, "NewFirstName");
			ps.setString(3, "NewLastName");
			ps.setInt(4, 27);
			ps.setString(5,"Bhopal");
			
			int rows = ps.executeUpdate();
			System.out.println(" Insert query successfull and changed rows - " + rows);
			ps.close();*/
			
			// callable statements
			/*CallableStatement cs = con.prepareCall("{call InsertStudentBasic(?,?,?)}");
			cs.setInt(1, 4);
			cs.setString(2, "Firstly");
			cs.setInt(3, 19);
			cs.execute();*/
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("Student - ");
				System.out.println(rs.getInt("RollNum"));
				System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
