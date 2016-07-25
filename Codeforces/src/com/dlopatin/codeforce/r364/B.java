package com.dlopatin.codeforce.r364;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/701/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long free = n * (long) n;
            boolean[] takenX = new boolean[n];
            boolean[] takenY = new boolean[n];
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                if (!takenX[x]) {
                    for (int j = 0; j < n; j++) {
                        if (!takenY[j]) {
                            free--;
                        }
                    }
                }
                if (!takenY[y]) {
                    for (int j = 0; j < n; j++) {
                        if (!takenX[j]) {
                            free--;
                        }
                    }
                }
                if (!takenX[x] && !takenY[y]) {
                    free++;
                }
                takenX[x] = true;
                takenY[y] = true;
                res.append(free).append(" ");
            }
            System.out.println(res.toString().trim());
        }

    }
}