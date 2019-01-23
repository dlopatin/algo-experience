package com.dlopatin.codeforce.div2.r357;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/681/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int c1 = 1234567;
            int c2 = 123456;
            double c3 = 1234;
            int n = scanner.nextInt();
            for (int a = 0; a <= n / c1; a++) {
                for (int b = 0; b <= (n - c1 * a) / c2; b++) {
                    if (((n - a * c1 - b * c2) % c3 == 0 && (n - a * c1 - b * c2) / c3 >= 0)
                            || n - a * c1 - b * c2 == 0) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
            System.out.println("NO");
        }
    }
}