package webface;

import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Edwin Hurst
 */
@WebService(serviceName = "webservice_NetDraw")
public class webservice_NetDraw {

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
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     * Removes a node from the network diagram.
     */
    
    @WebMethod(operationName = "logOff")
    @Oneway
    public void logOff(@WebParam(name = "name") String name) {
    }
}
