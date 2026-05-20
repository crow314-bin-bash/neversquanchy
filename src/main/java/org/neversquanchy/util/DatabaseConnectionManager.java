package org.neversquanchy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

	private static Connection connection;
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String user = "postgres";
	private static final String password = "iWillDi&H3r3";

	private DatabaseConnectionManager() {
	}

	public static synchronized Connection InitializeDatabaseConnection() {
		try {
			if (connection == null || DatabaseConnectionManager.connection.isClosed()) {
				connection = DriverManager.getConnection(url, user, password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static synchronized Connection databaseRequireConnection() {
		try {
			if (connection == null) {
				connection = DriverManager.getConnection(url, user, password);
			}
		}catch (SQLException e) {
			DatabaseConnectionManager.InitializeDatabaseConnection();
			e.printStackTrace();
		}
		return connection;	
	}
}