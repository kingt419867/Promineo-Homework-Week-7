package recipies.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipies.exception.DbException;

public class DbConnection {
	private static final String SCHEMA = "recipies";
	private static final String USER = "recipies";
	private static final String PASSWORD = "recipies";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	
	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting with url= " + url);
		
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection successful");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection error");
			throw new DbException(e);
			//e.printStackTrace();
		}
	}
	
}
