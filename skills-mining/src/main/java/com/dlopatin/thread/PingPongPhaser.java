package com.dlopatin.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

public class PingPongPhaser {

	private static final CountDownLatch COUNTDOWN = new CountDownLatch(100);
	private static final Phaser phaser = new Phaser(1);

	public static void main(String... args) {
		start("ping");
		start("pong");
	}

	private static void start(final String message) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (COUNTDOWN.getCount() > 0) {
					System.out.println(message);
					phaser.awaitAdvance(phaser.arrive() + 1);
					COUNTDOWN.countDown();
				}
			}
		}).start();
	}
}
