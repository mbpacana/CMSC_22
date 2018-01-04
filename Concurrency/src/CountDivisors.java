/**
 * Count divisors in sequence.
 * Created by nmenego on 11/16/16.
 */
public class CountDivisors {

    private int min = -1;
    private int max = -1;
    private int maxDivisorCount = 0;
    private int intWithMaxDivisorCount = -1;
    private boolean solved = false;

    public CountDivisors(int min, int max) {
        if (min >= max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        this.min = min;
        this.max = max;
    }

    public void run() {
        int maxDivisorCount = 0;
        int intWithMaxDivisorCount = 0;
        for (int i = min; i <= max; i++) {
            int divisors = countDivisors(i);
            // if divisors are more than current maximum..
            if (divisors > maxDivisorCount) {
                maxDivisorCount = divisors;
                intWithMaxDivisorCount = i;
            }
        }

        // assign the answers
        this.intWithMaxDivisorCount = intWithMaxDivisorCount;
        this.maxDivisorCount = maxDivisorCount;

        // set this counter to solved.
        this.solved = true;
    }

    /**
     * Finds the number of divisors of the integer N.
     * Note that this is a NAIVE solution.
     * See Sieve of Eratosthenes for a better solution.
     */
    private int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0)
                count++;
        }
        return count;
    }

    public int getMaxDivisorCount() throws Exception {
        if (!solved) {
            throw new Exception("Not yet solved!");
        }
        return maxDivisorCount;
    }

    public int getIntWithMaxDivisorCount() throws Exception {
        if (!solved) {
            throw new Exception("Not yet solved!");
        }
        return intWithMaxDivisorCount;
    }
}