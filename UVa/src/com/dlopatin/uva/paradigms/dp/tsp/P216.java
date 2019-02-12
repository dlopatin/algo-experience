package com.dlopatin.uva.paradigms.dp.tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=152
 * Getting in Line
 */
public class P216 {

    private static double[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseIdx = 1;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                result.append("**********************************************************\n")
                        .append("Network #")
                        .append(caseIdx++)
                        .append("\n");
                int n = parseInt(line);
                int[][] coord = new int[n][2];
                for (int i = 0; i < n; i++) {
                    StringTokenizer cTokens = new StringTokenizer(reader.readLine());
                    coord[i][0] = parseInt(cTokens.nextToken());
                    coord[i][1] = parseInt(cTokens.nextToken());
                }
                double[][] dist = new double[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dist[i][j] = Math.sqrt(Math.pow(coord[i][0] - coord[j][0], 2) +
                                Math.pow(coord[i][1] - coord[j][1], 2)) + 16;
                    }
                }
                dp = new double[n][1 << n];
                int[][] next = new int[n][1 << n];
                double ans = Integer.MAX_VALUE;
                int from = 0;
                for (int pos = 0; pos < n; pos++) {
                    double tsp = tsp(pos, 1 << pos, dist, next);
                    if (tsp < ans) {
                        ans = tsp;
                        from = pos;
                    }
                }
                int mask = 0;
                for (int i = 0; i < n - 1; i++) {
                    mask |= 1 << from;
                    int nextPos = next[from][mask];
                    result.append(String.format("Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n",
                            coord[from][0], coord[from][1], coord[nextPos][0], coord[nextPos][1], dist[from][nextPos]));
                    from = nextPos;
                }

                result.append(String.format("Number of feet of cable required is %.2f.\n", ans));
            }
            System.out.print(result);
        }

    }

    private static double tsp(int pos, int mask, double[][] dist, int[][] next) {
        int n = dist.length;
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (dp[pos][mask] != 0) {
            return dp[pos][mask];
        }

        double ans = Integer.MAX_VALUE;
        for (int nextPos = 0; nextPos < n; nextPos++) {
            if (nextPos != pos && (mask & (1 << nextPos)) == 0) {
                double newDist = dist[pos][nextPos] + tsp(nextPos, mask | (1 << nextPos), dist, next);
                if (newDist < ans) {
                    ans = newDist;
                    next[pos][mask] = nextPos;
                }
            }
        }
        dp[pos][mask] = ans;
        return ans;
    }

}

