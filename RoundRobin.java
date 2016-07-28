package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * This class is an implementation of the Round Robin scheduling Algorithm.
 *
 * @author mikias
 * @version Jul 9, 2016
 */
public class RoundRobin
{

    private Map<String, Long> run_times = new HashMap<>();
    private ArrayList<Thread> jobs;


    // ----------------------------------------------------------
    /**
     * Create a new RoundRobin object.
     *
     * @param jobs
     *            jobs are Threads that will be processed
     */
    public RoundRobin(ArrayList<Thread> jobs)
    {
        this.jobs = jobs;
    }


    // Round robin
    // ----------------------------------------------------------
    /**
     * rrb_process is the key method where the Round Robin Algorithm is defined
     *
     * @param jobs
     *            are a List of Threads that will be processed.
     * @throws InterruptedException
     */
    public void rrb_process(List<Thread> jobs)
        throws InterruptedException
    {

        int time_slice = 200;
        List<Thread> target_list = new ArrayList<>();

        // Exit if no jobs
        if (jobs.size() == 0)
            return;

        for (Thread job : jobs)
        {
            // Start or resume the jobs
            if (job.isAlive())
                job.resume();
            else
            {
                job.run();
                run_times.put(job.getName(), System.nanoTime());
                // Record when the job has started
            }
            // Process
            Thread.sleep(time_slice);

            // If alive suspend, else remove from job list
            if (job.isAlive())
            {
                job.suspend();
                target_list.add(job);
            }
            else
            {
                Long duration =
                    System.nanoTime() - run_times.get(job.getName());
                run_times.put(job.getName(), duration);
                // Record when the job is completed
            }
        }
        rrb_process(target_list);
        // Recursively execute the method until there is no job to be processed.

    }


    // ----------------------------------------------------------
    /**
     * returns a Map object run_times, of String, Long key/value pairs.
     *
     * @return run_times object
     */
    public Map<String, Long> getRun_times()
    {
        return run_times;
    }

    // ----------------------------------------------------------
    /**
     * run calls the rrb_priocess method with jobs.
     *
     * @throws InterruptedException
     */
    public void run()
        throws InterruptedException
    {
        System.out.println("Round Robin...");
        System.out.println("-------------------------------------------------");

        rrb_process(jobs);

    }
}
