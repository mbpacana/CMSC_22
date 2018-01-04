/**
 * Created by nmenego on 11/16/16.
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        Thread thread = new HelloThread();
        thread.start();
    }

}