package org.neversquanchy;

import java.util.Scanner;

import org.neversquanchy.util.DatabaseConnectionManager;

public class MainLauncher {
	
	public static void main(String[] args) {
		DatabaseConnectionManager.databaseRequireConnection();
		
		Scanner sc = new Scanner(System.in);
		
		String teste = sc.nextLine();
		
		sc.close();
	}
}
