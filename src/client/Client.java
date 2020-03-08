package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remoteInterfaces.ElectionRemoteInterface;
import server.remoteObjects.ElectionRemoteObject;

public class Client {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");	
			ElectionRemoteInterface server = (ElectionRemoteInterface) registry.lookup("Election");
			System.out.println("[log] Servidor conectado");
			
			//Election stub = (Election) registry.lookup("Election");
		} catch (RemoteException e) {
			System.err.println("[ERROR] Client (RemoteException): " + e.getMessage());
		} catch (Exception e) {
			System.err.println("[ERROR] Client (Exception): " + e.getMessage());
		}
	}

}
