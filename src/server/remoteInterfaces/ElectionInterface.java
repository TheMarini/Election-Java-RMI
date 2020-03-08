package server.remoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ElectionInterface extends Remote {
	String[] candidates() throws RemoteException;
	
	boolean vote(String nameCandidate, int hashVoter) throws RemoteException;
	
	List<List<String>> result() throws RemoteException;
}
