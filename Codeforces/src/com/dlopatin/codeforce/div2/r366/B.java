package com.dlopatin.codeforce.div2.r366;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/705/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            StringBuilder res = new StringBuilder();
            int prev = 2;
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (prev == 1) {
                    if (a % 2 == 0) {
                        prev = 2;
                    }
                } else {
                    if (a % 2 == 0) {
                        prev = 1;
                    }
                }
                res.append(prev);
                res.append("\n");
            }
            System.out.println(res.toString().trim());
        }
    }

}