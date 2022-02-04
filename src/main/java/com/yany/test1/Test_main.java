package com.yany.test1;


import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Test_main {

    public static volatile int i = 1;
    public static volatile int total = 30;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (total > 1) { // 3
                    if (i == 1) {
                        System.out.println(1);
                        i = 2;
                        total--; // 2
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (total > 1) { // 2
                    if (i == 2) {
                        System.out.println(2);
                        i = 3;
                        total--; // 1
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (total > 1) { // 1
                    if (i == 3) {
                        System.out.println(3);
                        i = 1;
                        total--; // 0
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }


}
