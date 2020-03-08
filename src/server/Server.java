package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remoteInterfaces.ElectionRemoteInterface;
import server.remoteObjects.ElectionRemoteObject;

public class Server {
	private static final int PORT = 4242;
	
	public static void main(String[] args) {
		try {			
			// Create RMI registry
	        LocateRegistry.createRegistry(PORT); 

	        ElectionRemoteInterface stub = new ElectionRemoteObject();
	        Registry registry = LocateRegistry.getRegistry();
	        
	        // Bind RMI registry with stub
	        registry.rebind("Election", stub);
	
	        System.out.println("[log] Server ready at PORT " + PORT);        
        } 
		catch (Exception e) {
            System.err.println("[ERROR] Server: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
