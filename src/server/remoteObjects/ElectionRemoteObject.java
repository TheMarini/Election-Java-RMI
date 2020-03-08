package server.remoteObjects;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import server.Candidate;
import server.remoteInterfaces.ElectionRemoteInterface;

public class ElectionRemoteObject extends UnicastRemoteObject implements ElectionRemoteInterface {
	// --- Attributes ---
	public Candidate[] candidates;
	
	// --- Methods ---
	public ElectionRemoteObject() throws RemoteException {
		super();
	}

	@Override
	public String[] candidates() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean vote(String nameCandidate, int hashVoter) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<String>> result() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
