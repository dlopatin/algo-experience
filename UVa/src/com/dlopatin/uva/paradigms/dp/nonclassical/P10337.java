package com.dlopatin.uva.paradigms.dp.nonclassical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1278
 * Flight Planner
 */
public class P10337 {

    public static final int MAX_VALUE = 10_000_000;
    private static int[][] DP;

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int x = parseInt(readNonNullLine(reader)) / 100;
                DP = new int[10][x];
                for (int[] ints : DP) {
                    Arrays.fill(ints, -1);
                }
                int[][] wind = new int[10][x];
                for (int i = 9; i >= 0; i--) {
                    StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < x; j++) {
                        wind[i][j] = parseInt(dataTokens.nextToken());
                    }
                }
                result.append(best(0, 0, x, wind)).append("\n\n");
            }
            System.out.print(result);
        }
    }

    private static int best(int alt, int x, int maxX, int[][] wind) {
        if (alt < 0 || alt > 9) {
            return MAX_VALUE;
        }
        if (x == maxX) {
            if (alt != 0) {
                return MAX_VALUE;
            }
            return 0;
        }
        if (DP[alt][x] == -1) {
            int min = MAX_VALUE;
            min = Math.min(best(alt - 1, x + 1, maxX, wind) - wind[alt][x] + 20, min);
            min = Math.min(best(alt, x + 1, maxX, wind) - wind[alt][x] + 30, min);
            min = Math.min(best(alt + 1, x + 1, maxX, wind) - wind[alt][x] + 60, min);
            DP[alt][x] = min;
        }
        return DP[alt][x];
    }

    private static String readNonNullLine(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) == null || line.isEmpty()) {
        }
        return line;
    }
}
