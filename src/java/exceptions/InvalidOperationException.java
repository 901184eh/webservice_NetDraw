package exceptions;

import java.rmi.RemoteException;

/**
 *
 * @author Edwin Hurst
 */
public class InvalidOperationException extends RemoteException {
    
    private String message;
    
    public InvalidOperationException(){
        super();
        message = "Description wasn't given.";
    }
    
    public InvalidOperationException(String description){
        super();
        message = description;
    }
    
    public String getDescription(){
        return message;
    }
}
