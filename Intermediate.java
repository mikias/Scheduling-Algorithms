package threads;

// -------------------------------------------------------------------------
/**
 * This is the implementation of theIntermediate class where CPU and IO
 * operations are both in-housed in one.
 *
 * @author mikias
 * @version Jul 7, 2016
 */
public class Intermediate
    extends Thread
{

    // ----------------------------------------------------------
    /**
     * main method for test
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Thread thread1 = new Intermediate(10, "ITM01");// Instantiate thread1
        Thread thread2 = new Intermediate(50, "ITM02");// Instantiate thread2
        Thread thread3 = new Intermediate(60, "ITM03");// Instantiate thread3
        Thread thread4 = new Intermediate(70, "ITM04");// Instantiate thread4
        Thread thread5 = new Intermediate(90, "ITM05");// Instantiate thread5
        Thread thread6 = new Intermediate(40, "ITM06");// Instantiate thread6
        Thread thread7 = new Intermediate(80, "ITM07");// Instantiate thread7

        thread1.start();// run thread1
        thread2.start();// run thread2
        thread3.start();// run thread3
        thread4.start();// run thread4
        thread5.start();// run thread5
        thread6.start();// run thread6
        thread7.start();// run thread7
    }

    private int num;


    // ----------------------------------------------------------
    /**
     * Create a new Intermediate object.
     *
     * @param num
     *            number to define.
     * @param name
     *            the name of the thread.
     */
    public Intermediate(int num, String name)
    {
        this.num = num;
        setName(name);

    }


    // ----------------------------------------------------------
    /**
     * The run method in-housing the IO and CPU operations for tests
     */
    public void run()
    {
        long startTime = System.nanoTime(); // start time elapsed
        int trial = 0; // trials to keep track of the number of attempts
        int answer = 0;// auto generated answers to be validated
        do
        {
            answer = (int)(Math.random() * 100 + 1); // random values generated
            // form 0 to 100.
            System.out.println(this.getClass() + " " + this.getName()
                + " check " + answer); // print
            // answer generating by the random class
            trial = trial + 1;

        }
        while (answer != num); // run while answer doesn't match the value
        long time = System.nanoTime() - startTime; // time until process ends
        synchronized (this)
        {

            System.out.println("right! " + this.getName() + " " + answer
                + " in " + trial + " tries." + " execution time:" + time
                + "(ns)");
            // print statement when the answer equals the target number defined
        }
    }

}
