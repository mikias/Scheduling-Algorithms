package threads;

import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * This is where the CPU intensive task is defined. A number is generated and
 * guessed automatically.
 *
 * @author mikias
 * @version Jul 7, 2016
 */
public class CPUBound
    extends Thread
{
    // ----------------------------------------------------------
    /**
     * main method to run local tests
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args)
        throws InterruptedException
    {
        Thread thread1 = new CPUBound(10, "CPU01");// Instantiate thread1
        Thread thread2 = new CPUBound(50, "CPU02");// Instantiate thread2
        Thread thread3 = new CPUBound(60, "CPU03");// Instantiate thread3
        Thread thread4 = new CPUBound(70, "CPU04");// Instantiate thread4
        Thread thread5 = new CPUBound(90, "CPU05");// Instantiate thread5
        Thread thread6 = new CPUBound(40, "CPU06");// Instantiate thread6
        Thread thread7 = new CPUBound(80, "CPU07");// Instantiate thread7

        thread1.start();// run thread1
        thread2.start();// run thread2
        thread3.start();// run thread3
        thread4.start();// run thread4
        thread5.start();// run thread5
        thread6.start();// run thread6
        thread7.start();// run thread7

    }

    private int num; //


    // ----------------------------------------------------------
    /**
     * Create a new CPUBound object.
     *
     * @param num
     *            number to defines
     * @param name
     *            name of thread
     */
    public CPUBound(int num, String name) // constructor for compute
    {
        this.num = num; // define target number
        setName(name);
    }


    // ----------------------------------------------------------
    /**
     * run method operating an CPU intensive task
     */
    public void run()
    {
        long startTime = System.nanoTime(); // start time elapsed
        int trial = 0; // trials
        int answer = 0;// auto generated answers
        do
        {
            answer = (int)(Math.random() * 100 + 1); // random values generated
            // form 0 to 100 and answered generating a random number
            trial = trial + 1;
        }
        while (answer != num); // number doesn't match the guessed answer
        long time = System.nanoTime() - startTime; // time until process ends
        synchronized (this)
        {
            System.out.println(this.getClass() + " " + this.getName() + " "
                + time + " (ns) elapsed ");
        }
    }
}
