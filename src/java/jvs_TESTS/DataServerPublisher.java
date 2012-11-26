package jvs_TESTS;

import javax.xml.ws.Endpoint;

/**
 *
 * @author vincent
 */
public class DataServerPublisher
{
    public static final String PUBLICATION_URL = "http://127.0.0.1";
    public static final int PORT = 9876;
    public static final String CHILD = "dataserver";
    public static final Object INSTANCE = ( new Datacollector() );
    
    public static void main( String[] args )
    {
        System.out.println("Publishing dataserver...");
        Endpoint.publish( (PUBLICATION_URL + ":" + PORT + "/" + CHILD), INSTANCE );
    }
}
