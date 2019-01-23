package com.dlopatin.codeforce.div2.r359;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/686/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            long x = scanner.nextLong();
            int sad = 0;
            while (n-- > 0) {
                String op = scanner.next();
                int amount = scanner.nextInt();
                if ("+".equals(op)) {
                    x += amount;
                } else {
                    if (x - amount >= 0) {
                        x -= amount;
                    } else {
                        sad++;
                    }
                }
            }
            System.out.println(String.format("%d %d", x, sad));
        }
    }
}