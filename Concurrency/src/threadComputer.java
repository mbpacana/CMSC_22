/**
 * Created by User on 11/22/2016.
 */
public class threadComputer {
    private int minIndex = -1;
    private int maxIndex = -1;
    private int direction = 0;
    private boolean solved = false;

    public threadComputer(int min,int max,int direction){
        if (min >= max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        this.direction = direction;
        minIndex = min;
        maxIndex = max;
    }

    public void run() {
        int maxDivisorCount = 0;
        int intWithMaxDivisorCount = 0;
        if()
        for (int curIndex = minIndex;true; i+=direction) {
            if(direction == -1 && curIndex >maxIndex ){
                break;
            }
            else(direction == -1 && curIndex >maxIndex ){
                break;
            }
            int divisors = countDivisors(i);
            // if divisors are more than current maximum..
            if (divisors > maxDivisorCount) {
                maxDivisorCount = divisors;
                intWithMaxDivisorCount = i;
            }
        }
        this.solved = true;
    }
}
