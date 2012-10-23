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
public class Member {
    private String computerName;
    private String accountName;
    private String softwareVersion;
    private String defaultGateway;
    private final String macAddress;
    private String ipAddress;
    
    public Member(String macAddress){
        this.macAddress = macAddress;
    }
}
