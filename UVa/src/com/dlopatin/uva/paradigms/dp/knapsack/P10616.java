package com.dlopatin.uva.paradigms.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1557
 *  Divisible Group Sums
 */
public class P10616 {

    private static long[][][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseIdx = 0;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer nqTokens = new StringTokenizer(line);
                int n = parseInt(nqTokens.nextToken());
                int q = parseInt(nqTokens.nextToken());
                int[] values = new int[n];
                for (int i = 0; i < values.length; i++) {
                    values[i] = parseInt(reader.readLine());
                }
                result.append(String.format("SET %d:\n", ++caseIdx));
                for (int i = 1; i <= q; i++) {
                    StringTokenizer dmTokens = new StringTokenizer(reader.readLine());
                    int d = parseInt(dmTokens.nextToken());
                    int c = parseInt(dmTokens.nextToken());
                    dp = new long[n][c + 1][d + 1];
                    for (long[][] ints2d : dp) {
                        for (long[] ints : ints2d) {
                            Arrays.fill(ints, -1);
                        }
                    }
                    long cnt = knapsack(n - 1, c, 0, d, values);
                    result.append(String.format("QUERY %d: %d\n", i, cnt));
                }
            }
            System.out.print(result);
        }
    }


    private static long knapsack(int idx, int wLeft, int sum, int div, int[] values) {
        if (wLeft == 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (idx < 0) {
            return 0;
        }
        if (dp[idx][wLeft][sum] != -1) {
            return dp[idx][wLeft][sum];
        }
        // as number can be negative, the mod also can be negative, but negative can't be used as index
        int trySum = ((values[idx] + sum) % div + div) % div;
        long result = knapsack(idx - 1, wLeft, sum, div, values) +
                knapsack(idx - 1, wLeft - 1, trySum, div, values);

        dp[idx][wLeft][sum] = result;
        return result;
    }

}

