package com.dlopatin.codeforce.div2.r240;

import java.util.Scanner;

/**
 * http://codeforces.ru/contest/415/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                long val = scanner.nextLong();
                long left = ((val * a) % b) / a;
                res.append(left).append(" ");
            }
            System.out.println(res.toString().trim());
        }
    }
}
