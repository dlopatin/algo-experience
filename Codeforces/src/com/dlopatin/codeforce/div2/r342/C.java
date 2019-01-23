package com.dlopatin.codeforce.div2.r342;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/625/problem/C
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt() - 1;
            int[][] matrix = new int[n][n];
            int number = 1;
            if (k > 0) {
                for (int row = 0; row < n; row++) {
                    for (int i = 0; i < k; i++) {
                        matrix[row][i] = number++;
                    }
                }
            }
            for (int row = 0; row < n; row++) {
                for (int i = k; i < n; i++) {
                    matrix[row][i] = number++;
                }
            }
            int sum = 0;
            for (int row = 0; row < n; row++) {
                sum += matrix[row][k];
            }
            System.out.println(sum);
            StringBuilder res = new StringBuilder();
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    res.append(matrix[row][col]);
                    if (col < n - 1) {
                        res.append(" ");
                    } else {
                        res.append("\n");
                    }
                }
            }
            System.out.println(res);

        }
    }
}