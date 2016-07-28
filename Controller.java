package threads;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class is an implementation of the Controller class, where classes
 * IOBound, CPUBound and Intermediate are orchestrated with the scheduling
 * algorithms.
 *
 * @author mikias
 * @version Jul 7, 2016
 */
public class Controller
{
    // ----------------------------------------------------------
    /**
     * This class is an implementation of the Controller class, where classes
     * IOBound, CPUBound and Intermediate are orchestrated with the scheduling
     * algorithms.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args)
        throws InterruptedException
    {
        // Defining threads to accept the jobs
        // ----------------------------------------------------------
        Thread thread1 = new Intermediate(10, "INT01");// Instantiate thread1
        Thread thread2 = new Intermediate(50, "INT02");// Instantiate thread2
        Thread thread3 = new CPUBound(60, "CPU01");// Instantiate thread3
        Thread thread4 = new CPUBound(70, "CPU02");// Instantiate thread4
        Thread thread5 = new IOBound(System.in, "IO01");// Instantiate thread5
        Thread thread6 = new IOBound(System.in, "IO02");// Instantiate thread6
        Thread thread7 = new Intermediate(82, "INT03");// Instantiate thread7
        Thread thread8 = new CPUBound(80, "CPU03");// Instantiate thread8

        // Creating a ArrayList of threads and adding the jobs to the ArrayList
        // ----------------------------------------------------------
        ArrayList<Thread> threadList = new ArrayList<Thread>();
        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        threadList.add(thread4);
        threadList.add(thread5);
        threadList.add(thread6);
        threadList.add(thread7);
        threadList.add(thread8);

        // Creating a FCFS object and running it with the created ArrayList
        // object
        // ----------------------------------------------------------
        FCFS fcfs = new FCFS(threadList);
        fcfs.run();

        // Displaying the results of the FCFS run
        // ----------------------------------------------------------

        System.out.println("----------------FCFS-----------------------------");
        for (String key : fcfs.getRun_times().keySet())
            System.out.println(key + " => " + fcfs.getRun_times().get(key));
        System.out.println("-------------------------------------------------");

        // Defining a Hash Map with key Long and value Thread. To pair
        // each unique time with a process
        // ----------------------------------------------------------
        Map<Long, Thread> threadList2 = new HashMap<Long, Thread>();
        threadList2.put(fcfs.getRun_times().get(thread1.getName()), thread1);
        threadList2.put(fcfs.getRun_times().get(thread2.getName()), thread2);
        threadList2.put(fcfs.getRun_times().get(thread3.getName()), thread3);
        threadList2.put(fcfs.getRun_times().get(thread4.getName()), thread4);
        threadList2.put(fcfs.getRun_times().get(thread5.getName()), thread5);
        threadList2.put(fcfs.getRun_times().get(thread6.getName()), thread6);
        threadList2.put(fcfs.getRun_times().get(thread7.getName()), thread7);
        threadList2.put(fcfs.getRun_times().get(thread8.getName()), thread8);

        // Creating a SJF object and running it with the created ArrayList
        // object
        // ----------------------------------------------------------
        SJF sjf = new SJF(threadList2);
        sjf.run();

        // Displaying the results of the SJF run
        // ----------------------------------------------------------
        System.out.println("-----------------SJF-----------------------------");
        for (String key : sjf.getRun_times().keySet())
            System.out.println(key + " => " + sjf.getRun_times().get(key));
        System.out.println("-------------------------------------------------");

        // Creating a RoundRobin object and running it with the previously
        // created ArrayList object holding our processes.
        // ----------------------------------------------------------
        RoundRobin roundRobin = new RoundRobin(threadList);
        roundRobin.run();

        // Displaying the results of the RoundRobin run
        // ----------------------------------------------------------
        System.out.println("-----------------Round Robin---------------------");
        for (String key : roundRobin.getRun_times().keySet())
            System.out.println(key + " => " + sjf.getRun_times().get(key));
        System.out.println("-------------------------------------------------");

    }

}
