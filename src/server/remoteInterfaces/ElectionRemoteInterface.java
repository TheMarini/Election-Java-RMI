package server.remoteInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import server.Candidate;

public interface ElectionRemoteInterface extends Remote {
	ArrayList<String> candidates() throws RemoteException;
	
	boolean vote(String nameCandidate, int hashVoter) throws RemoteException;
	
	ArrayList<Candidate> result() throws RemoteException;
}
