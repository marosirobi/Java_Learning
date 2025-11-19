package runningThreads;

public class RunningThreads {

    public static void main(String[] args) {

        System.out.println("The Main thread is running");
        try {
            System.out.println("The main thread is paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run.");
            for(int i = 0; i < 10; i++){
                System.out.print(". ");
                try {
                    Thread.sleep(500);
//                    System.out.println("A. state = " + Thread.currentThread().getState());
                }catch (InterruptedException e){
                    System.out.println("\nWhoops!! " + tname + " interrupted.");
//                    System.out.println("A1 state = " + Thread.currentThread().getState());
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println("\n" + tname + " completed.");
        });

        Thread installThread = new Thread(() ->{
           try{
               for(int i = 0; i < 3; i++){
                   Thread.sleep(250);
                   System.out.println("Installation step " + (i + 1) + " is completed.");
               }
           }catch(InterruptedException e){
               e.printStackTrace();
           }
        }, "InstallThread");


        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while(thread.isAlive()){
                try {
                    Thread.sleep(1000);
//                System.out.println("B. state = " + thread.getState());

                    if(System.currentTimeMillis() - now  > 8000){
                        thread.interrupt();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();
        System.out.println("The main thread would continue here");

//        System.out.println("C. state = " + thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(!thread.isInterrupted()){
            installThread.start();
        }else{
            System.out.println("Previous thread was interrupted, " + installThread.getName() +
                    " can't run.");
        }
    }


}
