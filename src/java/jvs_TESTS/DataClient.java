/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jvs_TESTS;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author vincent
 */
public class DataClient
{

    public static void main(String[] args)
    {
        URL url = null;
        try
        {
            url = new URL("http://localhost:9876/dataserver?wsdl");
        }
        catch (MalformedURLException ex)
        {
            System.out.println("**Slecht gevormde url.");
        }
        QName qualifiedNameOfService = new QName("http://jvs_TESTS/", "DatacollectorService");

        Service serviceFactory = Service.create(url, qualifiedNameOfService);

        // Extract the endpoint interface, the service "port".
        IDatacollector datacollector = serviceFactory.getPort(IDatacollector.class);
        
        datacollector.setProcessNames(new String[]{"bash", "vpnc"});
    }
}
