package com.madan.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmtDemo {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/training",
							"root", "new_password");
			
			String sqlQuery = "Select * from students where id > ?"
					+ " and firstname = ?";
			
			prepareStatement = connection.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, 3);
			prepareStatement.setString(2, "Bapuji");
			
			rs = prepareStatement.executeQuery();
			
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
				prepareStatement.close();
				connection.close();				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		

	}

}
