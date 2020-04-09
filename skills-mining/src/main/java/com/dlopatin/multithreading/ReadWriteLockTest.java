package com.dlopatin.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final List<Integer> storage = new ArrayList<>();

    public void add(int val) throws InterruptedException {
        rwLock.writeLock().lock();
        try {
            TimeUnit.SECONDS.sleep(1);
            storage.add(val);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public int get(int idx) throws InterruptedException {
        rwLock.readLock().lock();
        try {
            int val = storage.get(idx);
            TimeUnit.SECONDS.sleep(1);
            return val;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReadWriteLockTest test = new ReadWriteLockTest();
        executor.submit(() -> {
            test.add(1);
            return true;
        });
        Callable<Integer> getOp = () -> test.get(0);
        Future<Integer> submit1 = executor.submit(getOp);
        Future<Integer> submit2 = executor.submit(getOp);
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
    }

}
