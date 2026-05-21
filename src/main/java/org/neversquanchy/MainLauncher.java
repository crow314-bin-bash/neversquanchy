package org.neversquanchy;

import org.neversquanchy.core.ApplicationOrchestrator;

public class MainLauncher {

	public static String databasePasswd;
	
	public static void main(String[] args) {
		
		databasePasswd = args[0];

		System.out.println("Subindo Database...\n");
		ApplicationOrchestrator.upDatabase();
		System.out.println("Database subiu com sucesso!\n");
		

		for (int i = 0; i < ApplicationOrchestrator.connectionPool.length; i++) {
			System.out.println(ApplicationOrchestrator.connectionPool[i].requireDatabaseConnection());
		}
		
		System.out.println();
		
		System.out.println("Retornando última conexão\n" + "[" + ApplicationOrchestrator.connectionPool[2].requireDatabaseConnection() + "]" + "\n");
		System.out.println("Retornando segunda conexão\n" + "[" + ApplicationOrchestrator.connectionPool[1].requireDatabaseConnection() + "]" + "\n");
		System.out.println("Retornando primeira conexão\n" + "[" + ApplicationOrchestrator.connectionPool[0].requireDatabaseConnection() + "]" + "\n");
		
	}
}
