package com.dlopatin.uva.paradigms.dp.nonclassical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2259
 * How do you add?
 */
public class P787 {

    private static final int[][] DP = new int[101][101];

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            for (int[] ints : DP) {
                Arrays.fill(ints, -1);
            }
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer dataTokens = new StringTokenizer(line);
                int n = parseInt(dataTokens.nextToken());
                int k = parseInt(dataTokens.nextToken());
                result.append(ways(n, k)).append("\n");
            }
            System.out.print(result);
        }
    }

    private static int ways(int n, int k) {
        if (k == 1) {
            return 1;
        }
        if (DP[n][k] == -1) {
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += ways(n - i, k - 1);
                sum %= 1_000_000;
            }
            DP[n][k] = sum;
        }
        return DP[n][k];
    }
}
