package com.dlopatin.uva.paradigms.dp.coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1247
 * e-Coins
 */
public class P10306 {

    private static int[][][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                StringTokenizer ms = new StringTokenizer(reader.readLine());
                int m = parseInt(ms.nextToken());
                int s = parseInt(ms.nextToken());
                dp = new int[s + 1][s + 1][m];
                int[] x = new int[m];
                int[] y = new int[m];
                for (int i = 0; i < m; i++) {
                    StringTokenizer data = new StringTokenizer(reader.readLine());
                    x[i] = parseInt(data.nextToken());
                    y[i] = parseInt(data.nextToken());
                }
                reader.readLine();
                int sol = change(m - 1, 0, 0, x, y, s * s);
                result.append(sol == 100000 ? "not possible" : sol).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int change(int idx, int x, int y, int[] xData, int[] yData, int sum) {
        int squareSum = x * x + y * y;
        if (squareSum == sum) {
            return 0;
        }
        if (idx < 0 || squareSum > sum) {
            return 100000;
        }
        if (dp[x][y][idx] != 0) {
            return dp[x][y][idx];
        }
        int minChange = Math.min(change(idx - 1, x, y, xData, yData, sum), // don't take
                1 + change(idx, x + xData[idx], y + yData[idx], xData, yData, sum)); // take
        dp[x][y][idx] = minChange;
        return minChange;
    }

}

