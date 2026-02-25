package com.app.connection;
import java.sql.*;

public class DbConnection {
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","sarvesh@123");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
