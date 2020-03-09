package server.remoteObjects;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import server.Candidate;
import server.remoteInterfaces.ElectionRemoteInterface;

public class ElectionRemoteObject extends UnicastRemoteObject implements ElectionRemoteInterface {
	// --- Attributes ---
	public ArrayList<Candidate> candidates = new ArrayList<>();
	public ArrayList<Integer> voters = new ArrayList<>();
	
	// --- Methods ---
	public ElectionRemoteObject() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<String> candidates() throws RemoteException {
		ArrayList<String> names = new ArrayList<>();
		for (Candidate c : candidates)
			names.add(c.name);
		
		return names;
	}

	@Override
	public boolean vote(String nameCandidate, int hashVoter) throws RemoteException {
		if(voters.contains(hashVoter))
			return false;
		
		for (Candidate c: candidates) {
			if(c.name.equals(nameCandidate)) {
				c.votes++;
				voters.add(hashVoter);
				break;
			}
		}
		
		return true;
	}

	@Override
	public List<List<String>> result() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
