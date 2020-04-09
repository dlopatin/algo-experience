package com.dlopatin.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Phaser;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPhaser {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        fjp.invoke(new ForkAction(100, new Phaser(100)));
        System.out.println(fjp);
    }

    private static class ForkAction extends RecursiveAction {
        private static final long serialVersionUID = -1L;

        private final int phases;
        private final Phaser phaser;

        public ForkAction(int phases, Phaser phaser) {
            this.phases = phases;
            this.phaser = phaser;
        }

        @Override
        protected void compute() {
            if (phases == 1) {
                System.out.printf("wait: %s%n", Thread.currentThread());
                phaser.arriveAndAwaitAdvance();
                System.out.printf("done: %s%n", Thread.currentThread());
            } else {
                int left = phases / 2;
                int right = phases - left;
                invokeAll(new ForkAction(left, phaser), new ForkAction(right, phaser));
            }
        }
    }
}
