package section3;

public class LockingWithCustomObjects {

    public static  int counter1 = 0;
    public  static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    //Dont use synchronized keyword on method level rather use synchronized block
    public  static  void increment() {
        //class level locking
        synchronized (lock1) {
            counter1++;
        }

    }

    public  static synchronized   void increment1() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    increment1();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter is: "+counter1);
        System.out.println("The counter is: "+counter2);
    }

    public static void main(String[] args) {

        try {
            process();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
