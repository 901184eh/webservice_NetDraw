package logic;

import exceptions.InvalidOperationException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Edwin Hurst
 */
public class DomainController implements Remote {
    
    private Network network;
    
    public DomainController() throws RemoteException {
        network = new Network();
    }
    
    public boolean containsMember(Member member) throws RemoteException {
        return network.hasMember(member);
    }
    
    public void addMember(Member member) throws RemoteException{
        if(containsMember(member)){
            //find relevant exception or create custom exception
            throw new InvalidOperationException("This member has already joined the network");
        }
        network.addMember(member);
    }
    
    public void updateMember(Member member) throws RemoteException{
        if(!containsMember(member)){
            //find relevant exception or custom
            throw new InvalidOperationException("This member must join the network first");
        }
        network.updateMember(member);
    }
    
    public void removeMember(Member member) throws RemoteException{
        if(!containsMember(member)){
            //relevant or custom exception needed.
            throw new InvalidOperationException("This member is not a part of the network");
        }
        network.removeMember(member);
    }
    
    /**
     * Will Remove all Members that have not been updated recently.
     */
    public void cleanNetwork(){
        //remove all Members that have not been updated "recently".
    }
}
