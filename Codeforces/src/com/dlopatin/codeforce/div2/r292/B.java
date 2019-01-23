package com.dlopatin.codeforce.div2.r292;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/516/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int b = scanner.nextInt();
            int[] boys = new int[n];
            for (int i = 0; i < b; i++) {
                boys[scanner.nextInt()] = 1;
            }

            int g = scanner.nextInt();
            int[] girls = new int[m];
            for (int i = 0; i < g; i++) {
                girls[scanner.nextInt()] = 1;
            }

            int i = 0;
            int j = 0;
            boolean changed = false;
            while (true) {
                if ((boys[i] != girls[j])) {
                    boys[i] = girls[j] = 1;
                    boys[i % m] = girls[j % n] = 1;
                    changed = true;
                }
                i = ++i % n;
                j = ++j % m;
                if (i == 0 && j == 0) {
                    if (changed) {
                        changed = false;
                    } else {
                        break;
                    }
                }
            }

            boolean happy = true;
            for (int boy : boys) {
                happy &= boy == 1;
            }
            for (int girl : girls) {
                happy &= girl == 1;
            }
            System.out.println(happy ? "Yes" : "No");
        }
    }

}
