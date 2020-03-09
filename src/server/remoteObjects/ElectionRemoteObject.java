package server.remoteObjects;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Comparator;
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
		
		// Example candidates
		candidates.add(new Candidate("Bruno"));
		candidates.add(new Candidate("Carlos"));
		candidates.add(new Candidate("Maria"));
		candidates.add(new Candidate("Joao"));
		candidates.add(new Candidate("Eduarda"));
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
	public ArrayList<Candidate> result() throws RemoteException {
		candidates.sort((c1, c2) -> c1.votes - c2.votes);
		return candidates;
	}

}
