package com.company;

public class Main {

    public static void main(String[] args) {

        // Create 5 threads
        for (int i = 0; i < 10; i++) {
            new MyThread("Thread"+i);
        }


    }
}

class MyThread implements Runnable{

    private Thread thread;
    String threadName;
    @Override
    public void run() {
        System.out.println(threadName + "");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Currently in thread " + threadName + ", count is: " + i);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted,\n\t" + e.getMessage());
            }
        }
    }

    // New thread will be created from constructor, will immediately start
    // This allows threads to be created and started asynchronously, as they each begin as soon
    // as the instantiation statement is completed
    public MyThread(String thread){
        this.thread = new Thread(this, thread);
        this.thread.start();

        this.threadName = thread;
    }
}
