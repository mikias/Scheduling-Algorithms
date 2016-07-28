package threads;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class is an implementation of the FCFS scheduling Algorithm.
 *
 * @author mikias
 * @version Jul 7, 2016
 */
public class FCFS
{

    private Map<String, Long> run_times = new HashMap<>();

    private ArrayList<Thread> jobs;


    // ----------------------------------------------------------
    /**
     * Create a new FCFS object.
     *
     * @param list
     *            passes a thread object
     */
    public FCFS(ArrayList<Thread> list)
    {
        this.jobs = list;
    }


    // ----------------------------------------------------------
    /**
     * This is where the run() method is implemented with the FCFS Algorithm.
     *
     * @throws InterruptedException
     */
    public void run()
        throws InterruptedException
    {
        System.out.println("FCFC...");
        System.out.println("-------------------------------------------------");

        for (Thread job : jobs)
        {
            long startTime = System.nanoTime();
            job.start();

            while (job.isAlive())
                Thread.sleep(200);
            Long time = System.nanoTime() - startTime;
            run_times.put(job.getName(), time);

        }

    }


    // ----------------------------------------------------------
    /**
     * getRun_times() returns a Map object with a String/Long key/value pair
     * which is used to calculate the run times of the processes.
     *
     * @return run_times
     */
    public Map<String, Long> getRun_times()
    {
        return run_times;
    }
}
