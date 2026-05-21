package org.neversquanchy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.neversquanchy.MainLauncher;

public class DatabaseConnectionManager {

	private volatile Connection connection;
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String user = "postgres";
	private static final String password = MainLauncher.databasePasswd;

	private DatabaseConnectionManager() {
		this.connection = requireDatabaseConnection();
	}

	public static DatabaseConnectionManager initializeDatabaseConnection() {
		return new DatabaseConnectionManager();
	}

	public Connection requireDatabaseConnection() {
		try {
			if (connection == null || connection.isClosed()) { // impede que novas threads entrem na fila do synchronized sem verificar a conexão
				synchronized (this) {
					if (connection == null || connection.isClosed()) {
						connection = DriverManager.getConnection(url, user, password);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}