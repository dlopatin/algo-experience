package com.dlopatin.uva.paradigms.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1760
 * Trouble of 13-Dots
 */
public class P10819 {

    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer mnTokens = new StringTokenizer(line);
                int m = parseInt(mnTokens.nextToken());
                int n = parseInt(mnTokens.nextToken());
                int[] values = new int[n];
                int[] weights = new int[n];
                for (int i = 0; i < values.length; i++) {
                    StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                    weights[i] = parseInt(dataTokens.nextToken());
                    values[i] = parseInt(dataTokens.nextToken());
                }
                dp = new int[n][m + 201];
                for (int[] ints : dp) {
                    Arrays.fill(ints, -1);
                }
                int cnt = knapsack(n - 1, 0, m, values, weights);
                result.append(cnt).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int knapsack(int idx, int spent, int max, int[] values, int[] weights) {
        if (spent > max && spent < 1800 || spent > max + 200) {
            return Integer.MIN_VALUE;
        }
        if (idx < 0) {
            if (spent > max && spent <= 2000) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }
        if (dp[idx][spent] != -1) {
            return dp[idx][spent];
        }

        int result = Math.max(knapsack(idx - 1, spent, max, values, weights),
                values[idx] + knapsack(idx - 1, spent + weights[idx], max, values, weights));
        dp[idx][spent] = result;
        return result;
    }

}

