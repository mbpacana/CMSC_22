/**
 * This sample demonstrates the behaviour of multithreaded programs.
 * Created by nmenego on 11/16/16.
 */
public class ThreadSample {
    public static void main(String[] args) {
        MyThread mt = new MyThread("my-thread");
        // this will call run()
        mt.start();

        // do something else with the current thread (main)...
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "--> i = " + i + ", i * i = " + i * i);
        }
    }
}

class MyThread extends Thread {

    // constructor with name
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int count = 1, row = 1; row < 20; row++, count++) {
            System.out.print(Thread.currentThread().getName() + "--> ");
            for (int i = 0; i < count; i++) {
                System.out.print("*");
            }
            System.out.print('\n');
        }
    }
}