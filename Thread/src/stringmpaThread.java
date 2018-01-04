
public class stringmpaThread extends Thread {
    public int min = -1;
    public int max = -1;
    public char[] calculated;
    public stringmpaThread(int min, int max,int x) {
        if (min > max || min < 0 || max < 0) {
            throw new IllegalArgumentException("Bad arguments");
        }
        calculated = new char[x];
        this.min = min;
        this.max = max;
    }

    public void run(char[] arr) {
        System.out.println(" received in thread: "+new String(arr));
        int x = 0;
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
        System.out.print(new String(calculated));
    }
    public String getString(){
        return new String(calculated);
    }
}
