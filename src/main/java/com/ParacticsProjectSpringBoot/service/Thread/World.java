package com.ParacticsProjectSpringBoot.service.Thread;

public class World implements Runnable{

    @Override
    public void run() {
       for(int i=0; i<100; i++){
           System.out.println("World");
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
