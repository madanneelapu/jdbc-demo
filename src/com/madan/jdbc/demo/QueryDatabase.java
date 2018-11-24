package com.madan.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDatabase {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/training",
							"root", "new_password");
			
			statement = connection.createStatement();
			
			String sqlQuery = "Select * from students";
			
			rs = statement.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				int age = rs.getInt("age");
				
				System.out.println(id+"-"+firstName+" "+lastName+
						"-"+age);
			}
			
		}catch(Exception ex) {			
			ex.printStackTrace();
		}finally {
			try {
				rs.close();
				statement.close();
				connection.close();				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		

	}

}
