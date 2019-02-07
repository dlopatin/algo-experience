package com.dlopatin.uva.paradigms.dp.coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=293
 * Let Me Count The Ways
 */
public class P357 {

    private static long[][] dp;
    private static final int[] TYPES = new int[]{1, 5, 10, 25, 50};

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            dp = new long[TYPES.length][30_001];
            for (long[] rows : dp) {
                Arrays.fill(rows, -1);
            }
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = parseInt(line);
                if (n < 5) {
                    result.append(String.format("There is only 1 way to produce %d cents change.\n", n));
                } else {
                    long ways = ways(TYPES.length - 1, n);
                    result.append(String.format("There are %d ways to produce %d cents change.\n", ways, n));
                }
            }
            System.out.print(result);
        }
    }

    private static long ways(int typeIdx, int value) {
        if (value < 0 || typeIdx < 0) {
            return 0L;
        }
        if (value == 0) {
            return 1L;
        }
        if (dp[typeIdx][value] != -1L) {
            return dp[typeIdx][value];
        }
        long ways = ways(typeIdx - 1, value) + // ignore this typeIdx
                ways(typeIdx, value - TYPES[typeIdx]); // use this coin typeIdx
        dp[typeIdx][value] = ways;
        return ways;
    }


}

