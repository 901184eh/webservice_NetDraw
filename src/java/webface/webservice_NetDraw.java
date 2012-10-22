/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webface;

import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Braeburn
 */
@WebService(serviceName = "webservice_NetDraw")
public class webservice_NetDraw {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "uploadData")
    public void uploadData(@WebParam(name = "name") String name) throws Exception {
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDiagram")
    public ArrayList getDiagram() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logOff")
    @Oneway
    public void logOff(@WebParam(name = "name") String name) {
    }
}
