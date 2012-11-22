package webface;

import exceptions.InvalidOperationException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import logic.DomainController;
import logic.Member;

/**
 *
 * @author Edwin Hurst
 */
@WebService(serviceName = "webservice_NetDraw")
public class webservice_NetDraw {
    
    private static DomainController dc;
    
    public webservice_NetDraw()
    {
        try {
            dc = new DomainController();
        } catch (RemoteException ex) {
            Logger.getLogger(webservice_NetDraw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     * Adds a new node to the network diagram.
     */
    
    @WebMethod(operationName = "uploadData")
    public void uploadData(@WebParam(name = "name") String name) throws Exception {
        
    }

    /**
     * Web service operation
     * Describes the network as the server currently recognises it.
     */
    
    @WebMethod(operationName = "getDiagram")
    public ArrayList getDiagram() {
        return null;
    }

    /**
     * Web service operation
     * Removes a node from the network diagram.
     */
    
    @WebMethod(operationName = "logOff")
    public void logOff(@WebParam(name = "name") String name) throws RemoteException{
        try {
            dc.removeMember(new Member("mac address", "softVer"));
        } catch (InvalidOperationException ex) {
            //doesn't really matter as it doesn't exist in the list.
        }
    }
}
