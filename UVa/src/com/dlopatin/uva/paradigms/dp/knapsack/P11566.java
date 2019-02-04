package com.dlopatin.uva.paradigms.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2613
 * Let's Yum Cha!
 */
public class P11566 {

    private static int[][][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while (!"0 0 0 0".equals(line = readNotNullLine(reader))) {
                StringTokenizer nxtkTokens = new StringTokenizer(line);
                int n = parseInt(nxtkTokens.nextToken());
                int x = parseInt(nxtkTokens.nextToken());
                int t = parseInt(nxtkTokens.nextToken());
                int k = parseInt(nxtkTokens.nextToken());
                int[] values = new int[k * 2];
                int[] weights = new int[k * 2];
                for (int i = 0; i < k; i++) {
                    StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                    int price = parseInt(dataTokens.nextToken());
                    weights[i * 2] = price;
                    weights[i * 2 + 1] = price;
                    int value = 0;
                    for (int j = 0; j <= n; j++) {
                        value += parseInt(dataTokens.nextToken());
                    }
                    values[i * 2] = value;
                    values[i * 2 + 1] = value;
                }
                int div = BigDecimal.valueOf(x * (n + 1))
                        .divide(new BigDecimal("1.1"), BigDecimal.ROUND_DOWN).intValue();
                int cost = div - t * (n + 1);
                dp = new int[2 * k][cost + 1][2 * (n + 1) + 1];
                for (int[][] ints2d : dp) {
                    for (int[] ints : ints2d) {
                        Arrays.fill(ints, -1);
                    }
                }
                int cnt = knapsack(2 * k - 1, cost, 2 * (n + 1), values, weights);
                result.append(String.format("%.2f\n", (double) cnt / (n + 1)));
            }
            System.out.print(result);
        }
    }

    private static int knapsack(int idx, int leftMoney, int leftDishes, int[] values, int[] weights) {
        if (idx < 0 || leftMoney == 0 || leftDishes == 0) {
            return 0;
        }
        if (dp[idx][leftMoney][leftDishes] != -1) {
            return dp[idx][leftMoney][leftDishes];
        }
        int result = 0;
        if (weights[idx] > leftMoney) {
            result = knapsack(idx - 1, leftMoney, leftDishes, values, weights);
        } else {
            result = Math.max(knapsack(idx - 1, leftMoney, leftDishes, values, weights),
                    values[idx] + knapsack(idx - 1, leftMoney - weights[idx], leftDishes - 1, values, weights));
        }
        dp[idx][leftMoney][leftDishes] = result;
        return result;
    }

    private static String readNotNullLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        while (line == null || line.isEmpty()) {
            line = reader.readLine();
        }
        return line;
    }

}

