package com.dlopatin.patterns;

import java.util.concurrent.ThreadLocalRandom;

public class PrivateConstructorCapture {
    private static class A {
        public A(int n) {
        }
    }

    private static class B extends A {
        private final int n;

        public B() {
            // store some value in current class
            this(ThreadLocalRandom.current().nextInt());
        }

        private B(int n) {
            super(n);
            this.n = n;
        }

    }
}
