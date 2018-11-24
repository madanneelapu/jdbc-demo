package com.madan.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDatabase {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/training",
							"root", "new_password");
			
			statement = connection.createStatement();
			
			String sqlQuery = "insert into students (id, firstname, lastname, age)"
					+ " values (6, 'Pavani', 'Lankalappali', 24)";
			
			int rowCount = statement.executeUpdate(sqlQuery);
			
			System.out.println("Rows Affected: "+rowCount);
			
		}catch(Exception ex) {			
			ex.printStackTrace();
		}finally {
			try {				
				statement.close();
				connection.close();				
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		

	}

}
