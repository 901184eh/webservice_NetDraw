package jvs_TESTS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author vincent
 */

@WebService
@SOAPBinding(style = Style.RPC)
public interface IDatacollector
{
    @WebMethod
    void setProcessNames( String[] processList );
}