package com.dlopatin.uva.paradigms.dp.max2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3102
 * Area
 */
public class P11951 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                maxSumKadanesMod(reader, result, caseIdx);
//                maxArraySumN4(reader, result, caseIdx);
            }
            System.out.print(result);
        }
    }

    /**
     * O(n^3)
     */
    private static void maxSumKadanesMod(BufferedReader reader, StringBuilder result, int caseIdx) throws IOException {
        StringTokenizer nmk = new StringTokenizer(reader.readLine());
        int n = parseInt(nmk.nextToken());
        int m = parseInt(nmk.nextToken());
        int k = parseInt(nmk.nextToken());
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer data = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = parseLong(data.nextToken());
                if (i > 0) {
                    a[i][j] += a[i - 1][j];
                }
            }
        }

        long bestArea = 0;
        long bestCost = 0;
        for (int topRow = 0; topRow < n; topRow++) {
            for (int botRow = topRow; botRow < n; botRow++) {
                int leftCol = 0;
                long area;
                long cost = 0;
                for (int rightCol = 0; rightCol < m; rightCol++) {
                    long sum = a[botRow][rightCol];
                    if (topRow > 0) {
                        sum -= a[topRow - 1][rightCol];
                    }
                    cost += sum;
                    while (cost > k) {
                        cost -= a[botRow][leftCol];
                        if (topRow > 0) {
                            cost += a[topRow - 1][leftCol];
                        }
                        leftCol++;
                    }
                    area = (botRow - topRow + 1) * (rightCol - leftCol + 1);
                    if (area == bestArea && cost < bestCost || area > bestArea) {
                        bestCost = cost;
                        bestArea = area;
                    }
                }
            }
        }
        result.append(String.format("Case #%d: %d %d\n", caseIdx, bestArea, bestCost));
    }

    /**
     * O(n^4)
     */
    private static void maxArraySumN4(BufferedReader reader, StringBuilder result, int caseIdx) throws IOException {
        StringTokenizer nmk = new StringTokenizer(reader.readLine());
        int n = parseInt(nmk.nextToken());
        int m = parseInt(nmk.nextToken());
        int k = parseInt(nmk.nextToken());
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer data = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = parseLong(data.nextToken());
                if (i > 0) {
                    a[i][j] += a[i - 1][j];
                }
                if (j > 0) {
                    a[i][j] += a[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    a[i][j] -= a[i - 1][j - 1];
                }
            }
        }

        int bestArea = 0;
        long p = Long.MAX_VALUE;
        for (int is = 0; is < n; is++) {
            for (int js = 0; js < m; js++) {
                for (int ie = is; ie < n; ie++) {
                    for (int je = js; je < m; je++) {
                        int area = (ie - is + 1) * (je - js + 1);
                        if (area >= bestArea) {
                            long cost = a[ie][je];
                            if (is > 0) {
                                cost -= a[is - 1][je];
                            }
                            if (js > 0) {
                                cost -= a[ie][js - 1];
                            }
                            if (is > 0 && js > 0) {
                                cost += a[is - 1][js - 1];
                            }
                            if (cost <= k && (area == bestArea && cost < p || area > bestArea)) {
                                p = cost;
                                bestArea = area;
                            }
                        }
                    }
                }
            }
        }
        result.append(String.format("Case #%d: %d %d\n", caseIdx, bestArea, p == Long.MAX_VALUE ? 0 : p));
    }


}

