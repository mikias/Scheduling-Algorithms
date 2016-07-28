package threads;
import java.util.Scanner;
import java.util.Random;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------------------------------------------------------
/**
 * This is where the IOBound intensive task is defined. The user is prompted to
 * enter an input and an output is generated.
 * @author mikias
 * @version Jul 6, 2016
 */
public class IOBound
    extends Thread
{

    // ----------------------------------------------------------
    /**
     * This is the main method for test runs.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[])
        throws IOException
    {
        Thread thread1 = new IOBound(System.in, "IO01");// Instantiate thread1
        Thread thread2 = new IOBound(System.in, "IO02");// Instantiate thread2
        Thread thread3 = new IOBound(System.in, "IO03");// Instantiate thread3
        Thread thread4 = new IOBound(System.in, "IO04");// Instantiate thread4
        Thread thread5 = new IOBound(System.in, "IO05");// Instantiate thread5
        Thread thread6 = new IOBound(System.in, "IO06");// Instantiate thread6
        Thread thread7 = new IOBound(System.in, "IO07");// Instantiate thread7

        thread1.start();// run thread1
        thread2.start();// run thread2
        thread3.start();// run thread3
        thread4.start();// run thread4
        thread5.start();// run thread5
        thread6.start();// run thread6
        thread7.start();// run thread7

    }


    // ----------------------------------------------------------
    /**
     * Create a new IOBound object.
     *
     * @param in
     *            input from the users
     * @param name
     *            name of the thread
     */
    public IOBound(InputStream in, String name)
    {
        setName(name);
    }


    // ----------------------------------------------------------
    /**
     * run method operating an IO intensive task
     *
     * @throws IOException
     */
    public void run()
    {
        Scanner reader = new Scanner(System.in); // await a user input
        long startTime = System.nanoTime(); // start time elapsed

        for (int i = 0; i < 5; i++)
        {
            synchronized (this)
            {
                System.out.println("Enter a text for " + this.getName());
                String input = reader.nextLine();
                System.out.println(input);
            }
        }
        long time = System.nanoTime() - startTime; // time until process ends
        synchronized (this)
        {
            System.out.println(this.getClass()
                + " I/O operation completed for " + this.getName() + " in :"
                + time + "(ns)");
        }
    }
}
