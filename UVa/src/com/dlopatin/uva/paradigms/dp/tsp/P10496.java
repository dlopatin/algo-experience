package com.dlopatin.uva.paradigms.dp.tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1437
 * Collecting Beepers
 */
public class P10496 {

    private static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                reader.readLine();
                StringTokenizer initPos = new StringTokenizer(reader.readLine());
                int n = parseInt(reader.readLine());
                int[] x = new int[n + 1];
                int[] y = new int[n + 1];
                x[0] = parseInt(initPos.nextToken());
                y[0] = parseInt(initPos.nextToken());
                for (int i = 1; i <= n; i++) {
                    StringTokenizer peepTokens = new StringTokenizer(reader.readLine());
                    x[i] = parseInt(peepTokens.nextToken());
                    y[i] = parseInt(peepTokens.nextToken());
                }
                int[][] dist = new int[n + 1][n + 1];
                for (int i = 0; i < dist.length; i++) {
                    for (int j = 0; j < dist[i].length; j++) {
                        dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                    }
                }
                dp = new int[n + 1][1 << (n + 1)];
                int ans = tsp(0, 1, dist);
                result.append("The shortest path has length ").append(ans).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int tsp(int pos, int mask, int[][] dist) {
        int n = dist.length;
        if (mask == (1 << n) - 1) {
            return dist[pos][0];
        }
        if (dp[pos][mask] != 0) {
            return dp[pos][mask];
        }

        int ans = Integer.MAX_VALUE;
        for (int nextPos = 0; nextPos < n; nextPos++) {
            if (nextPos != pos && (mask & (1 << nextPos)) == 0) {
                ans = Math.min(ans, dist[pos][nextPos] + tsp(nextPos, mask | (1 << nextPos), dist));
            }
        }
        dp[pos][mask] = ans;
        return ans;
    }

}

