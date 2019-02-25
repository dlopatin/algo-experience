package com.dlopatin.uva.paradigms.dp.nonclassical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1662
 * Bar Codes
 */
public class P10721 {

    private static long[][] DP;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer nkm = new StringTokenizer(line);
                int n = parseInt(nkm.nextToken());
                int k = parseInt(nkm.nextToken());
                int m = parseInt(nkm.nextToken());
                DP = new long[n + 1][k + 1];
                for (long[] ints : DP) {
                    Arrays.fill(ints, -1);
                }
                result.append(ways(n, k, m)).append("\n");
            }
            System.out.print(result);
        }
    }

    private static long ways(int n, int k, int m) {
        if (k == 0 && n == 0) {
            return 1;
        }
        if (n == 0 || k == 0) {
            return 0;
        }
        if (DP[n][k] == -1) {
            long sum = 0;
            for (int i = 1; i <= m && n >= i; i++) {
                sum += ways(n - i, k - 1, m);
            }
            DP[n][k] = sum;
        }
        return DP[n][k];
    }
}
