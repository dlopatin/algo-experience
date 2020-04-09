package com.dlopatin.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingPongSynchronized {

    private static final CountDownLatch COUNTDOWN = new CountDownLatch(100);
    public static AtomicBoolean lock = new AtomicBoolean();

    public static void main(String... args) {
        start("ping");
        start("pong");
    }

    private static void start(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (COUNTDOWN.getCount() > 0) {
                        if ("ping".equals(message)) {
                            if (lock.get()) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            lock.set(true);
                        } else {
                            if (!lock.get()) {
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            lock.set(false);
                        }
                        System.out.println(message);
                        COUNTDOWN.countDown();
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }
}
