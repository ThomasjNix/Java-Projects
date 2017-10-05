package com.company;

public class Main {

    public static void main(String[] args) {

        // Create two threads
        MyThread aNewThread = new MyThread("Thread0");
        Thread newThread1 = new Thread(aNewThread);
        MyThread aNewThread2 = new MyThread("Thread1");
        Thread newThread2 = new Thread(aNewThread2);

        // First thread will run, second will run only once first finished executing (thread terminates)
        newThread1.run();
        newThread2.run();
    }
}

class MyThread implements Runnable{

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

    public MyThread(String thread){
        this.threadName = thread;
    }
}
