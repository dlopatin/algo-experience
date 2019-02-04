package com.dlopatin.uva.paradigms.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2613
 * Let's Yum Cha!
 */
public class P11566 {

    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0 0 0 0".equals(line)) {
                StringTokenizer nxtkTokens = new StringTokenizer(line);
                int n = parseInt(nxtkTokens.nextToken());
                int x = parseInt(nxtkTokens.nextToken());
                int t = parseInt(nxtkTokens.nextToken());
                int k = parseInt(nxtkTokens.nextToken()) + 1;
                int[] values = new int[k];
                int[] weights = new int[k];
                for (int i = 0; i < values.length; i++) {
                    StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                    weights[i] = parseInt(dataTokens.nextToken());
                    values[i] = parseInt(dataTokens.nextToken());
                }
                dp = new int[n][201];
                for (int[] ints : dp) {
                    Arrays.fill(ints, -1);
                }
                int cnt = knapsack(n - 1, 0, 10000, values, weights);
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

