package server.remoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface ElectionRemoteInterface extends Remote {
	ArrayList<String> candidates() throws RemoteException;
	
	boolean vote(String nameCandidate, int hashVoter) throws RemoteException;
	
	List<List<String>> result() throws RemoteException;
}
