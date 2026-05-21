package org.neversquanchy.core;

import org.neversquanchy.util.DatabaseConnectionManager;

public class ApplicationOrchestrator {

	private static final int POOLMAXIMUMSIZE = 3;
	public static DatabaseConnectionManager[] connectionPool = new DatabaseConnectionManager[POOLMAXIMUMSIZE]; 
	
	public static void upDatabase() {
		
		for(int i = 0; i < connectionPool.length; i++) {
			connectionPool[i] = DatabaseConnectionManager.initializeDatabaseConnection();
		}
	}
}
