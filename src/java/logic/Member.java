package logic;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Edwin Hurst
 * Represents a client connected to the network.
 */
public class Member implements Comparable<Member>, Remote {
    private static final Pattern IPV4_PATTERN = 
        Pattern.compile(
                "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    private static final Pattern IPV6_STD_PATTERN = 
        Pattern.compile(
                "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = 
        Pattern.compile(
                "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    
    
    private String computerName;
    private String accountName;
    private final String softwareVersion;
    private String defaultGateway;
    private final String macAddress;
    private String ipAddress;
    
    /**
     *
     * @param macAddress
     */
    public Member(String macAddress, String softwareVersion) throws RemoteException {
        //moet voldeon aan MAC pattern.
        this.macAddress = macAddress;
        // kan dit ook nakijken als wij dit regelen.
        this.softwareVersion = softwareVersion;
    }
    
    /**
     *
     * @return
     */
    public String getMacAddress() throws RemoteException {
        return macAddress;
    }
    
    /**
     *
     * @return
     */
    public String getComputerName() throws RemoteException {
        return computerName;
    }
    
    /**
     *
     * @return
     */
    public String getAccountName() throws RemoteException {
        return accountName;
    }
    
    /**
     *
     * @return
     */
    public String getSoftwareVersion() throws RemoteException {
        return softwareVersion;
    }
    
    /**
     *
     * @return
     */
    public String getDefaultGateway() throws RemoteException {
        return defaultGateway;
    }
    
    /**
     *
     * @return
     */
    public String getIPAddress() throws RemoteException {
        return ipAddress;
    }
    
    /**
     *
     * @param computerName
     */
    public void setComputerName(String computerName) throws RemoteException {
        //Null mag niet.
        this.computerName = computerName;
    }
    
    /**
     *
     * @param accountName
     */
    public void setAccountName(String accountName) throws RemoteException {
        //Null mag niet.
        this.accountName = accountName;
    }
    
    /**
     *
     * @param defaultGateway
     */
    public void setDefaultGateway(String defaultGateway) throws RemoteException {
        //address moet voldoen aan IPv4/6 patroon. Null mag well.
        if(isIPv4Address(defaultGateway) || isIPv6Address(defaultGateway) || (defaultGateway == null) || defaultGateway.isEmpty()){
            this.defaultGateway = defaultGateway;
        }else{
            //throw InvalidIPAddressException;
        }
    }
    
    /**
     *
     * @param ipAddress
     */
    public void setIPAddress(String ipAddress) throws RemoteException {
        //address moet voldoen aan IP patroon (ofwel v4 of v6). Null mag niet.
        if(isIPv4Address(ipAddress) || isIPv6Address(ipAddress)){
            this.ipAddress = ipAddress;
        }else{
            //throw InvalidIPAddressException;
        }
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Member t) {
        try {
            return macAddress.compareTo(t.getMacAddress());
        } catch (RemoteException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //TODO: aanpassen
        return 0;
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
        try {
            return macAddress.equals(m.getMacAddress());
        } catch (RemoteException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        //TODO: aanpassen
        return false;
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
    
    private static boolean isIPv4Address(String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    private static boolean isIPv6StdAddress(String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }
    
    private static boolean isIPv6HexCompressedAddress(String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }
    
    private static boolean isIPv6Address(String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input); 
    }
}
