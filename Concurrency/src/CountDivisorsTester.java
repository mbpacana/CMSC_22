/**
 * Created by nmenego on 11/16/16.
 */
public class CountDivisorsTester {

    public static final int MIN = 1;
    public static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        CountDivisors countDivisors = new CountDivisors(MIN, MAX);
        countDivisors.run();
        // print results
        System.out.println("RESULTS");
        System.out.println("int with max divisors: " + countDivisors.getIntWithMaxDivisorCount());
        System.out.println("divisor count: " + countDivisors.getMaxDivisorCount());
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));


    }
}