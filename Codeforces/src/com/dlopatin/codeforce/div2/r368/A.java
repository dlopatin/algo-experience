package com.dlopatin.codeforce.div2.r368;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/707/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char ch = scanner.next().charAt(0);
                    if (ch == 'C' || ch == 'M' || ch == 'Y') {
                        System.out.println("#Color");
                        return;
                    }
                }
            }
            System.out.println("#Black&White");
        }
    }
}