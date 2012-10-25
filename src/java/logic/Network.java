package logic;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edwin Hurst
 */
public class Network {
    
    private Set<Member> members;
    
    /**
     *
     */
    public Network(){
        members = new HashSet<Member>();
    }
    
    /**
     *
     * @param client
     */
    public void addMember(Member client){
        
    }
    
    /**
     *
     * @param member
     * @return
     */
    public boolean hasMember(Member member){
        return members.contains(member);
    }
}
