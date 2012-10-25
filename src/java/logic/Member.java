/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Braeburn
 * Represents a client connected to the network.
 */
public class Member implements Comparable<Member> {
    private String computerName;
    private String accountName;
    private String softwareVersion;
    private String defaultGateway;
    private final String macAddress;
    private String ipAddress;
    
    /**
     *
     * @param macAddress
     */
    public Member(String macAddress){
        this.macAddress = macAddress;
    }
    
    /**
     *
     * @return
     */
    public String getMacAddress(){
        return macAddress;
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Member t) {
        return macAddress.compareTo(t.getMacAddress());
    }
    
    /**
     *
     * @param t
     * @return
     */
    @Override
    public boolean equals(Object t){
        if(!(t instanceof Member)){
            return false;
        }
        Member m = (Member) t;
        return macAddress.equals(m.getMacAddress());
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.macAddress != null ? this.macAddress.hashCode() : 0);
        return hash;
    }
}
