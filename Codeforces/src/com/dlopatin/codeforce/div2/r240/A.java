package com.dlopatin.codeforce.div2.r240;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/415/A
 */

public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] lamps = new int[n];
            for (int i = 0; i < m; i++) {
                int pressed = scanner.nextInt();
                for (int j = pressed - 1; j < n; j++) {
                    if (lamps[j] == 0) {
                        lamps[j] = pressed;
                    } else {
                        break;
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                res.append(lamps[i]).append(" ");
            }
            System.out.println(res.toString().trim());
        }
    }
}
