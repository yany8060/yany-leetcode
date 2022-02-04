package com.yany;


import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock l = new ReentrantReadWriteLock();
        l.readLock().tryLock(1, TimeUnit.HOURS);

        HashMap a = new HashMap();

        ArrayBlockingQueue aaa = new ArrayBlockingQueue(10);

        ThreadLocal<Integer> ac = new ThreadLocal<>();

    }
}


class ResourceClass implements Runnable {
    public static volatile int i = 0;
    public static Object lock = new Object();

    public void run() {
        synchronized (lock) {
            while (i < 100) {
                System.out.println(++i);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (Exception e) {
                }
            }

        }
    }
}