package ru_jb.less3_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class less3_5_CyclicBarrier {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;
        CyclicBarrier cb = new CyclicBarrier(THREADS_COUNT);
        for (int i = 0; i < THREADS_COUNT; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("Подготавливается " + index);
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("Готов" + index);
                    cb.await();
                    Thread.sleep(2000 + 500 * (int) (Math.random() * 10));
                    System.out.println("Доехал" + index);
                    cb.await();
                    System.out.println("Гонка закончилась" + index);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
