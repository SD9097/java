package Section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{

    private int id;

    public Task(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Task with id "+id+" is in work - thread id: "+Thread.currentThread().getId());
        long duration = (long) Math.random() * 5;
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++){
            executor.execute(new Task(i));
        }

        executor.shutdown();

//        try{
//            if(!executor.awaitTermination(1000,java.util.concurrent.TimeUnit.MILLiSECONDS)){
//
//            }
//        }catch (Exception e){
//            executor.shutdownNow();
//        }
    }

}
