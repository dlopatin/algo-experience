package com.dlopatin.codeforce.div2.r367;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/706/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            double res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                double xy = Math.sqrt(Math.pow((a - x), 2) + Math.pow((b - y), 2));
                res = Math.min(res, xy / scanner.nextInt());
            }
            System.out.printf("%.6f", res);
        }
    }
}