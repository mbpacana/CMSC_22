import java.util.Scanner;

/**
 * Source code by Pacana on 8/17/16.
 */
public class MP5 {
    public static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        boolean[][] arr = new boolean[x][x];

        // seed
        int seedIndex = x / 2;
        arr[0][seedIndex] = true;

        for (int i = 1; i < x; i++) {
            for (int j = 0; j < x; j++) {

                boolean m = j - 1 >= 0 ? arr[i - 1][j - 1] : false;
                boolean n = arr[i - 1][j];
                boolean o = j + 1 < x ? arr[i - 1][j + 1] : false;
                if ((m && n) || (m && o) || (!m && !n && !o)) {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        print(arr);
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