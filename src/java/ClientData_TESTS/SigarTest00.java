package ClientData_TESTS;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.ProcState;

/**
 *
 * @author vincent
 */
public class SigarTest00
{

    private static Sigar sigar = new Sigar();

    public static void main(String[] args)
    {
        getInformationsAboutCPU();
        getInformationsAboutMemory();
        getInformationsAboutFileSystem();

        getSystemProcesses();
    }

    public static void getInformationsAboutCPU()
    {
        System.out.println("************************************");
        System.out.println("*** Informations about the CPUs: ***");
        System.out.println("************************************\n");

        CpuInfo[] cpuinfo = null;
        try
        {
            cpuinfo = sigar.getCpuInfoList();
        }
        catch (SigarException se)
        {
            se.printStackTrace();
        }

        System.out.println("---------------------");
        System.out.println("Sigar found " + cpuinfo.length + " CPU(s)!");
        System.out.println("---------------------");

        for (int i = 0; i < cpuinfo.length; i++)
        {
            Map map = cpuinfo[i].toMap();
            System.out.println("CPU " + i + ": " + map);
        }

        System.out.println("\n************************************\n");
    }

    public static void getInformationsAboutMemory()
    {
        System.out.println("**************************************");
        System.out.println("*** Informations about the Memory: ***");
        System.out.println("**************************************\n");

        Mem mem = null;
        try
        {
            mem = sigar.getMem();
        }
        catch (SigarException se)
        {
            se.printStackTrace();
        }

        Map map = mem.toMap();
        System.out.println(map);

        System.out.println("\nPretty printed:");
        System.out.println("---------------");
        System.out.println("Actual total free system memory: "
                + mem.getActualFree() / 1024 + " KB");
        System.out.println("Actual total used system memory: "
                + mem.getActualUsed() / 1024 + " KB");
        System.out.println("Total free system memory ......: " + mem.getFree()
                / 1024 + " KB");
        System.out.println("System Random Access Memory....: " + mem.getRam()
                + " MB");
        System.out.println("Total system memory............: " + mem.getTotal()
                / 1024 + " KB");
        System.out.println("Total used system memory.......: " + mem.getUsed()
                / 1024 + " KB");

        System.out.println("\n**************************************\n");
    }

    public static void getInformationsAboutFileSystem()
    {
        System.out.println("******************************************");
        System.out.println("*** Informations about the FileSystem: ***");
        System.out.println("******************************************\n");

        FileSystem[] filesystem = null;
        try
        {
            filesystem = sigar.getFileSystemList();
        }
        catch (SigarException se)
        {
            se.printStackTrace();
        }

        System.out.println("---------------------");
        System.out.println("Sigar found " + filesystem.length + " drives!");
        System.out.println("---------------------");

        for (int i = 0; i < filesystem.length; i++)
        {
            Map map = filesystem[i].toMap();
            System.out.println("drive " + i + ": " + map);
        }

        System.out.println("\n******************************************");
    }

    public static void getSystemProcesses()
    {
        Map runningProcesses = null;
        //String pmn = null;
        long[] procLijst = null;
        long procId = 0;

        try
        {
            runningProcesses = sigar.getProcStat().toMap();
            //pmn = sigar.getProcState("State.Name.eq=vpnc").toString();
            procLijst = sigar.getProcList();
        }
        catch (SigarException ex)
        {
            Logger.getLogger(SigarTest00.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("******************************************");
        System.out.println("*** Information about system processes:***");
        System.out.println("******************************************");

        System.out.println("Running processes: " + runningProcesses.toString());

        //System.out.println("Running processes(vpnc): " + pmn);

        System.out.println("Processlist: ");
        for (long proc : procLijst)
        {
            try
            {
                System.out.println(proc + " - " + sigar.getProcState(proc).getName());
            }
            catch (SigarException ex)
            {
                Logger.getLogger(SigarTest00.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.print( "Get process details (pid): " );
        try
        {
             ProcState processState = sigar.getProcState("Pid.Pid.eq=" + ( new Scanner( System.in ) ).nextLong());
             System.out.println("Process name: " + processState.getName());
             System.out.println("Process Nice: " + processState.getNice());
             System.out.println("Process Priority: " + processState.getPriority());
             System.out.println("Process processor where it last ran: " + processState.getProcessor());
             System.out.println("Process status: " + processState.getState());
             System.out.println("Process Threads: " + processState.getThreads());
             System.out.println("Process screen-device: " + processState.getTty());
             System.out.println("All process data: " + processState.toString());
        }
        catch (SigarException ex)
        {
            Logger.getLogger(SigarTest00.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
