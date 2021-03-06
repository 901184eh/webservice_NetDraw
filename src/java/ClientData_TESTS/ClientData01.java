/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientData_TESTS;

import java.io.File;

/**
 *
 * @author vincent
 */
public class ClientData01
{

    public static void main(String[] args)
    {
        String processorIdent = System.getenv("PROCESSOR_IDENTIFIER");
        String processorArch = System.getenv("PROCESSOR_ARCHITECTURE");
        String processorArchBit = System.getenv("PROCESSOR_ARCHITEW6432");
        String processorEnvProc = System.getenv("NUMBER_OF_PROCESSORS");
        
        System.out.println("-------------------------------------------------");
        System.out.println("processorIdent: " + processorIdent);
        System.out.println("processorArch: " + processorArch);
        System.out.println("processorArchBit: " + processorArchBit);
        System.out.println("processorEnvProc: " + processorEnvProc);
        System.out.println("-------------------------------------------------");
        
        /* Total number of processors or cores available to the JVM */
        System.out.println("Available processors (cores): "
                + Runtime.getRuntime().availableProcessors());

        /* Total amount of free memory available to the JVM */
        System.out.println("Free memory (bytes): "
                + Runtime.getRuntime().freeMemory());

        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        System.out.println("Maximum memory (bytes): "
                + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

        /* Total memory currently in use by the JVM */
        System.out.println("Total memory (bytes): "
                + Runtime.getRuntime().totalMemory());

        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();

        /* For each filesystem root, print some info */
        for (File root : roots)
        {
            System.out.println("File system root: " + root.getAbsolutePath());
            System.out.println("Total space (bytes): " + root.getTotalSpace());
            System.out.println("Free space (bytes): " + root.getFreeSpace());
            System.out.println("Usable space (bytes): " + root.getUsableSpace());
        }
    }
}