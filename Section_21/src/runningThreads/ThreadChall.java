package runningThreads;

import java.util.Random;

class FirstThread extends Thread{

    Random rand = new Random();

    private int randNum(){
        int num = -1;
        while(num % 2 != 0){
            num = rand.nextInt(1,100);
        }
        return num;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){

            System.out.print(randNum() + ", ");
            try {
                Thread.sleep(250);
            }catch (InterruptedException e){
                System.out.println("\nWhoops!! " + Thread.currentThread().getName() + " interrupted.");
                break;
            }
        }
    }
}

class SecondThread implements Runnable{

    Random rand = new Random();

    private int randOdd(){
        int num = 0;
        while(num % 2 == 0){
            num = rand.nextInt(1,100);
        }
        return num;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){

            System.out.print(randOdd() + ", ");
            try {
                Thread.sleep(250);
            }catch (InterruptedException e){
                System.out.println("\nWhoops!! " + Thread.currentThread().getName() + " interrupted.");
                break;
            }
        }
    }
}

public class ThreadChall {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for(int i = 1; i < 10; i+=2){

                System.out.print(i + ", ");
                try {
                    Thread.sleep(250);
                }catch (InterruptedException e){
                    System.out.println("\nWhoops!! " + Thread.currentThread().getName() + " interrupted.");
                    break;
                }
            }
        };

        Thread secondThread = new Thread(runnable);
        FirstThread firstThread = new FirstThread();
        firstThread.start();
        secondThread.start();

        long now = System.currentTimeMillis();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstThread.interrupt();


    }


}
