package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author mikias
 * @version Jul 7, 2016
 */
public class SJF
{
    private Map<String, Long> run_times = new HashMap<>();
    Map<Long, Thread> sjf_job_map = new HashMap<Long, Thread>();


    // ----------------------------------------------------------
    /**
     * Create a new SJF object.
     *
     * @param list
     */
    public SJF(Map<Long, Thread> sjf_job_map)
    {
        this.sjf_job_map = sjf_job_map;
    }

    public void sjf_process()
        throws InterruptedException
    {

        long startTime = System.nanoTime();

        SortedSet<Long> duration = new TreeSet<Long>(sjf_job_map.keySet());
        for (Long key : duration)
        {
            Thread job = new Thread(sjf_job_map.get(key));
            job.setName(sjf_job_map.get(key).getName());
            job.start();
            while (job.isAlive())
                Thread.sleep(200);

            Long time = System.nanoTime() - startTime;
            run_times.put(job.getName(), time);
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @throws InterruptedException
     */
    public void run()
        throws InterruptedException
    {
        System.out.println("Shortest Jobs First...");
        System.out.println("-------------------------------------------------");

        try
        {
            sjf_process();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Map<String, Long> getRun_times()
    {
        return run_times;
    }
}
