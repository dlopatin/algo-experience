package com.dlopatin.codeforce.educational.r59;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1107/problem/D
 */
public class D {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nk = new StringTokenizer(reader.readLine());
            int n = parseInt(nk.nextToken());
//            int[][] a = new int[n][n];
            int[][] sum = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                char[] row = reader.readLine().toCharArray();
                for (int j = 0; j < row.length; j++) {
                    char c = row[j];
                    int hex = parseInt(Character.toString(c), 16);
                    for (int r = 0; r < 4; r++) {
                        int jj = j * 4 + r;
                        int val = (hex & 1 << (3 - r)) >>> (3 - r);
                        sum[i + 1][jj + 1] = val + sum[i][jj + 1] + sum[i + 1][jj] - sum[i][jj];
                    }
                }
            }
            int maxX = 0;
            for (int x = 1; x * x <= n; x++) {
                if (n % x == 0) {
                    if (can(x, sum)) {
                        maxX = Math.max(maxX, x);
                    }
                    if (can(n / x, sum)) {
                        maxX = Math.max(maxX, n / x);
                    }
                }
            }
            System.out.println(maxX);
        }
    }

    private static boolean can(int x, int[][] sum) {
        boolean equal = true;
        int n = sum.length;
        for (int i = x; i < n && equal; i += x) {
            for (int j = x; j < n && equal; j += x) {
                int areaSum = sum[i][j] - sum[i][j - x] - sum[i - x][j] + sum[i - x][j - x];
                if (areaSum != 0 && areaSum != x * x) {
                    equal = false;
                }
            }
        }
        return equal;
    }

}