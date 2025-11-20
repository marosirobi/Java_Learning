package multipleThreads;

import java.util.concurrent.TimeUnit;

public class CachedData {

    private volatile boolean flag = false;

    public void toggleFlage(){
        flag = !flag;
    }

    public boolean isReady(){
        return flag;
    }

    public static void main(String[] args) {

        CachedData exm = new CachedData();

        Thread writerThread = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            exm.toggleFlage();
            System.out.println("A. Flag set to " + exm.isReady());
        });

        Thread readerThread = new Thread(() -> {
            while (!exm.isReady()){

            }
            System.out.println("B. Flag is " + exm.isReady());
        });

        writerThread.start();
        readerThread.start();

    }
}
