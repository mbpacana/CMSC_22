/**
 * Created by User on 11/30/2016.
 */
public class mpaThread extends Thread {
    public int min = -1;
    public int max = -1;
    char[] calculated;
    public mpaThread(int min, int max,int x) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        calculated = new char[max - min];
        this.min = min;
        this.max = max;
    }

    public void run(char[] arr) {

        int x=0;
        for(int j = min; j <= max; j++) {
            char m = j - 1 >= 0 ? arr[j - 1] : 0;
            char n = arr[j];
            char o = j + 1 < arr.length ? arr[j + 1] : 0;
            if ((m == '1' && n == '1') || (m == '1' && o == '1') || (m== '0' && n == '0' && o == '0')) {
                calculated[x++] = '0';
            } else {
                calculated[x++] = '1';
            }
        }
    }
    public String toString(){
        return calculated.toString();
    }

}
