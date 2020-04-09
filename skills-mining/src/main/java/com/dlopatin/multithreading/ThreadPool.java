package com.dlopatin.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final int size;
    private final BlockingQueue<Runnable> queue;


    public ThreadPool(int size) {
        this.size = size;
        queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < size; i++) {
            Thread newThread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } catch (Throwable th) {
                        // no action
                    }
                }
            });
            newThread.start();
        }
    }

    public void submit(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}