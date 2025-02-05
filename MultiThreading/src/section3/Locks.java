package section3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    //Reenterant Lock is a lock that can be reentered by the same thread
    //it is fair lock

    private static  int counter = 0;

    //fairness is true by default
    private static Lock locks = new ReentrantLock();

    private static void increment() {

        locks.lock();

        try{
            for(int i = 0; i < 10000; i++) {
                counter++;
            }
        }finally {
            locks.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
