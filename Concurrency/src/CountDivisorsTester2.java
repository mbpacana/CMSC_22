/**
 * Created by nmenego on 11/16/16.
 */
public class CountDivisorsTester2 {

    public static final int MIN = 1;
    public static final int MAX = 100000;
    public static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        int globalMaxDivisorCount = 0;
        int whichInt = 0;

        // create 10 CountDivisorsThread as workers
        CountDivisorsThread[] worker = new CountDivisorsThread[THREAD_COUNT];
        // divide total range to equal chunks..
        int integersPerThread = MAX / THREAD_COUNT;
        // starting point for first thread
        int start = MIN;
        // end point for range of ints
        int end = start + integersPerThread - 1;

        // initialize the tasks of our workers by assigning them to chunks of work
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (i == THREAD_COUNT - 1) {
                // make sure last thread processes up until MAX
                end = MAX;
            }
            worker[i] = new CountDivisorsThread(start, end);
            // Determine the range of ints for the next thread.
            start = end + 1;
            end = start + integersPerThread - 1;
        }

        // start our workers by calling start() method
        for (int i = 0; i < THREAD_COUNT; i++) {
            // this will call run()
            worker[i].start();
        }

        // we want to wait for the workers to die before displaying the final results!
        for (int i = 0; i < THREAD_COUNT; i++) {
            while (worker[i].isAlive()) {
                try {
                    worker[i].join();
                } catch (InterruptedException e) {
                    System.err.println("thread interrupted: " + e.getMessage());
                }
            }
        }

        // get the maximum for each of the threads:
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (globalMaxDivisorCount < worker[i].getMaxDivisorCount()) {
                globalMaxDivisorCount = worker[i].getMaxDivisorCount();
                whichInt = worker[i].getIntWithMaxDivisorCount();
            }
        }

        System.out.println("RESULTS");
        System.out.println("int with max divisors: " + whichInt);
        System.out.println("divisor count: " + globalMaxDivisorCount);
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));

    }
}