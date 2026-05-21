package org.neversquanchy;

import java.util.Scanner;

import org.neversquanchy.util.DatabaseConnectionManager;

public class MainLauncher {
	
	public static void main(String[] args) {
		DatabaseConnectionManager.initializeDatabaseConnection();
		
		Scanner sc = new Scanner(System.in);
		
		DatabaseConnectionManager.databaseRequireConnection();
		
		System.out.println(DatabaseConnectionManager.databaseRequireConnection());
		
		sc.close();
	}
}
