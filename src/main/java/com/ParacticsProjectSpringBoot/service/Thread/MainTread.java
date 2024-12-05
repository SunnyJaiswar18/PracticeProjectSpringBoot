package com.ParacticsProjectSpringBoot.service.Thread;

public class MainTread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        World world =new World();
        Thread thread = new Thread(world);  //NEW STATE
        thread.start();                     //RUNNABLE (Ready to run)
        for(int i=0; i<=100;i++){
            System.out.println("hello");
            Thread.sleep(200);
        }
    }
}
