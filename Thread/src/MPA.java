import java.util.*;

public class MPA extends Thread{
    public static int TNUM = 10;
    public static char[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        x= 20;
        long time = System.currentTimeMillis();

        if(x< TNUM){
            TNUM = x;
        }

        arr = new char[x];
        int seedIndex = x / 2;
        for(int i = 0;i < x ;i++){ arr[i] = '0';}
        arr[seedIndex] = '1';
        int integersPerThread = x / TNUM;
        System.out.println ("mao ni"+new String(arr));

        for(int k = 1; k < x; k++){
            stringmpaThread[] worker = new stringmpaThread[TNUM];
            int start = 0;
            int end = start + integersPerThread - 1;

            for (int i = 0; i < TNUM; i++) {
                if (i == TNUM - 1) {
                    end = x - 1;
                }
                worker[i] = new stringmpaThread(start, end, x);
                start = end + 1;
                end = start + integersPerThread - 1;
            }

            for (int i = 0; i < TNUM; i++) {
                worker[i].run(arr);
            }

            for (int i = 0; i < TNUM; i++) {
                while (worker[i].isAlive()) {
                    try {
                        worker[i].join();
                    }catch (InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            System.out.println();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("time is: "+(time2-time)+"ms");

    }

    public static void print(boolean[][] arr) {
        for (boolean[] boolArr : arr) {
            for (boolean bool : boolArr) {
                if (bool) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
    }
}
