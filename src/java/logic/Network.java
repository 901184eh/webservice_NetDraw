package logic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edwin Hurst
 */
public class Network implements Remote {
    
    private Set<Member> members;
    private int expiryTime;
    
    /**
     * Creates an empty Network which represents a collection of Members.
     */
    public Network() throws RemoteException {
        members = new HashSet<Member>();
        expiryTime = 30000;
    }
    
    /**
     * Adds a Member to the network. Will fail if it is already a part of the Network
     * as HashSet doesn't allow duplicates. 
     * @param client
     */
    public void addMember(Member client) throws RemoteException {
        members.add(client);
    }
    
    /**
     * Replaces a member with the newest version (or adds it to the Network)
     * @param client
     */
    public void updateMember(Member client) throws RemoteException {
        removeMember(client);
        addMember(client);
    }
    
    /**
     * Removes a Member (if present) from the Network.
     * @param client
     */
    public void removeMember(Member client) throws RemoteException {
        members.remove(client);
    }
    
    /**
     *
     * @param member
     * @return true when the Member is a part of the Network. False otherwise.
     */
    public boolean hasMember(Member member) throws RemoteException {
        return members.contains(member);
    }
    
    /**
     * Sets the time after which a Member will be removed (during the next cleanup)
     * @param timeOut The time in milliseconds after which a member must update.
     */
    public void setExpiryTime(int timeOut) throws RemoteException {
        expiryTime = timeOut;
    }
}
