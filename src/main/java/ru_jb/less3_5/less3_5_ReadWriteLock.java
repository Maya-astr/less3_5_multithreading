package ru_jb.less3_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class less3_5_ReadWriteLock {
    public static void main(String[] args) {
        final ReadWriteLock rWL = new ReentrantReadWriteLock();
        for (int i = 0; i< 3; i++){
            int index = i;
            new Thread(()-> {
                try{
                    rWL.readLock().lock();
                    System.out.println("3-start read - " + index);
                    shortSleep(1000);
                    System.out.println("3-stop read - " + index);
                } finally {
                    rWL.readLock().unlock();
                }
           
            }).start();
        }
        for (int i = 0; i < 2; i++){
            int index = i;
            new Thread(()-> {
                try{
                    rWL.readLock().lock();
                    System.out.println("2-start write - " + index);
                    shortSleep(1000);
                    System.out.println("2-stop write - " + index);
                } finally {
                    rWL.readLock().unlock();
                }

            }).start();
        }
    }
    public static void shortSleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
