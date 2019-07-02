package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ComumDAO {

	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/restaurante", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return connection;
	}

}
