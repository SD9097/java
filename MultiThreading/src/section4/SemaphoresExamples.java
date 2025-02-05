package section4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3,true);

    public void download(){
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Downloading data from the web...");
    }
}

public class SemaphoresExamples {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i = 0; i < 12 ; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.download();
                }
            });
        }
    }

}
