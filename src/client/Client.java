package client;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import server.remoteInterfaces.ElectionRemoteInterface;

public class Client {
	private static Registry registry;
	private static ElectionRemoteInterface server;
	
	public static void main(String[] args) {
		if (connect())
			menu();
	}
	
	public static void menu() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			// Show
			System.out.println("\n           ### Election ###           ");
			System.out.println("========================================");
			System.out.println("|     1 - Configure server address     |");
			System.out.println("|     2 - View candidates              |");
			System.out.println("|     3 - Vote for a candidate         |");
			System.out.println("|     4 - Election result              |");
			System.out.println("|     0 - Sair                         |");
			System.out.println("========================================\n");
			System.out.print("> ");
			
			// Select option
			option = input.nextInt();
			System.out.print("\n");
			
			// Execute option
			switch (option) {
				case 1:
					break;
					
				case 2:
					candidates();
					break;
					
				case 3:
					//vote();
					break;
					
				case 4:
					//result();
					break;
			}
			
			pause();
		} while (option != 0);
	}
	
	public static void pause() {
		System.out.println("Press Enter to continue…");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void candidates() {
		try {
			for(String names : server.candidates())
				System.out.println(names);
		} catch (RemoteException e) {
			System.err.println("[ERROR] Client on getting candidates: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean connect() {
		try {
			registry = LocateRegistry.getRegistry("localhost");	
			server = (ElectionRemoteInterface) registry.lookup("Election");
			
			// Success
			System.out.println("[log] Servidor conectado");
			return true;
		} catch (RemoteException | NotBoundException e) {
			System.err.println("[ERROR] Client on connect: " + e.getMessage());
		}
		
		// Error
		System.err.println("[ERROR] Não foi possível conectar no servidor :(");
		return false;
	}
}
