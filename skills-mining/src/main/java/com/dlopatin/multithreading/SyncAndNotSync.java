package com.dlopatin.multithreading;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncAndNotSync {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        int[] data = new int[]{1, 2};
        executor.submit(new Runnable() {
            @Override
            public void run() {
                synchronized (data) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    data[0] = 10;
                }

            }
        });
        data[1] = 20;
        System.out.println(Arrays.toString(data));
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println(Arrays.toString(data));
    }
}
