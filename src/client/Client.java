package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remoteInterfaces.ElectionRemoteInterface;
import server.remoteObjects.ElectionRemoteObject;

public class Client {
	private static Registry registry;
	private static ElectionRemoteInterface server;
	
	public static void main(String[] args) {
		if (connect()) {
			System.out.println(candidate());
		}
	}
	
	public static String[] candidate() {
		try {
			return server.candidates();
		} catch (RemoteException e) {
			System.err.println("[ERROR] Client on getting candidates: " + e.getMessage());
			e.printStackTrace();
		}
		
		return null;
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
