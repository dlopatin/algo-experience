package com.dlopatin.y2016.round1;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            final int p = scanner.nextInt();
            final int a = scanner.nextInt();
            final int b = scanner.nextInt();
            int result = -1;
            if (b <= p) {
                result = Math.max(a + b, p);
            }
            System.out.println(result);
        }
    }

}