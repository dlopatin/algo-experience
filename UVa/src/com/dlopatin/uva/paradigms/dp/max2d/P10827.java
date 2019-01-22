package com.dlopatin.uva.paradigms.dp.max2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1768
 * Maximum sum on a torus
 */
public class P10827 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                int[][] a = new int[2 * n][2 * n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer data = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < n; j++) {
                        a[i][j] = parseInt(data.nextToken());
                    }
                    System.arraycopy(a[i], 0, a[i], n, n);
                }
                System.arraycopy(a, 0, a, n, n);
//                for (int[] ints : a) {
//                    for (int i : ints) {
//                        result.append(String.format("%2d", i)).append(" ");
//                    }
//                    result.append("\n");
//                }
                result.append(findMaxSum(a)).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int findMaxSum(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = a[i][j];
                if (i > 0) {
                    b[i][j] += b[i - 1][j];
                }
                if (j > 0) {
                    b[i][j] += b[i][j - 1];
                }
                if (j > 0 && i > 0) {
                    b[i][j] -= b[i - 1][j - 1];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int n = b.length;
        int m = b[0].length;
        int lim = m / 2;
        for (int startI = 0; startI < lim; startI++) {
            for (int startJ = 0; startJ < lim; startJ++) {
                for (int endI = startI; endI < startI + lim; endI++) {
                    for (int endJ = startJ; endJ < startJ + lim; endJ++) {
                        int sum = b[endI][endJ];
                        if (startI > 0) {
                            sum -= b[startI - 1][endJ];
                        }
                        if (startJ > 0) {
                            sum -= b[endI][startJ - 1];
                        }
                        if (startI > 0 && startJ > 0) {
                            sum += b[startI - 1][startJ - 1];
                        }
                        max = Math.max(sum, max);
                    }
                }
            }
        }
        return max;
    }

}

