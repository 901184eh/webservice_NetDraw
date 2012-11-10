package logic;

import exceptions.InvalidOperationException;

/**
 *
 * @author Edwin Hurst
 */
public class DomainController {
    
    private Network network;
    
    public DomainController(){
        network = new Network();
    }
    
    public boolean containsMember(Member member){
        return network.hasMember(member);
    }
    
    public void addMember(Member member) throws InvalidOperationException{
        if(containsMember(member)){
            //find relevant exception or create custom exception
            throw new InvalidOperationException("This member has already joined the network");
        }
        network.addMember(member);
    }
    
    public void updateMember(Member member) throws InvalidOperationException{
        if(!containsMember(member)){
            //find relevant exception or custom
            throw new InvalidOperationException("This member must join the network first");
        }
        network.updateMember(member);
    }
    
    public void removeMember(Member member) throws InvalidOperationException{
        if(!containsMember(member)){
            //relevant or custom exception needed.
            throw new InvalidOperationException("This member is not a part of the network");
        }
        network.removeMember(member);
    }
    
    public void cleanNetwork(){
        //remove all Members that have not been updated "recently".
    }
}
