package com.dlopatin.uva.comletesearch.iterative.fancy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3488
 * Zones
 */
public class P1047 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseNumber = 0;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer nm = new StringTokenizer(line);
                int n = parseInt(nm.nextToken());
                int b = parseInt(nm.nextToken());
                StringTokenizer towerCustomerTokens = new StringTokenizer(reader.readLine());
                int[] towerCustomers = new int[n];
                for (int i = 0; i < n; i++) {
                    towerCustomers[i] = parseInt(towerCustomerTokens.nextToken());
                }
                int m = parseInt(reader.readLine());
                int[][] unions = new int[m][n + 1];
                for (int i = 0; i < m; i++) {
                    StringTokenizer unionTokens = new StringTokenizer(reader.readLine());
                    int t = parseInt(unionTokens.nextToken());
                    for (int j = 0; j < t; j++) {
                        unions[i][j] = parseInt(unionTokens.nextToken());
                    }
                    unions[i][n] = parseInt(unionTokens.nextToken());
                }

                int globalSum = 0;
                int[] bestTowers = new int[b];
                for (int subset = (1 << b) - 1;
                    // if n=5 and b=3, then max value in binary is 11100
                     subset <= (((1 << n) - 1) ^ (1 << n - b) - 1);
                     subset++) {
                    if (Integer.bitCount(subset) == b) {
                        int localSum = 0;
                        int[] usedTowers = new int[b];
                        int usedTowerIdx = 0;
                        for (int idx = 0; idx < n; idx++) {
                            if ((subset & (1 << idx)) > 0) {
                                localSum += towerCustomers[idx];
                                usedTowers[usedTowerIdx++] = idx;
                            }
                        }
                        for (int[] union : unions) {
                            int intervals = 0;
                            for (int j = 0; j < n; j++) {
                                if (union[j] == 0) {
                                    break;
                                }
                                intervals += ((1 << union[j] - 1) & subset) > 0 ? 1 : 0;
                            }
                            if (intervals > 0) {
                                localSum -= union[union.length - 1] * (intervals - 1);
                            }
                        }

                        if (globalSum < localSum
                                || (globalSum == localSum && towersInPriority(bestTowers, usedTowers))) {
                            globalSum = localSum;
                            bestTowers = usedTowers;
                        }
                    }
                }
                result.append("Case Number  ").append(++caseNumber).append("\n");
                result.append("Number of Customers: ").append(globalSum).append("\n");
                result.append("Locations recommended: ");
                for (int i = 0; i < bestTowers.length; i++) {
                    result.append(bestTowers[i] + 1);
                    if (i != bestTowers.length - 1) {
                        result.append(" ");
                    }
                }
                result.append("\n\n");
            }
            System.out.print(result);
        }
    }

    private static boolean towersInPriority(int[] stored, int[] newOnes) {
        for (int i = 0; i < stored.length; i++) {
            if (stored[i] > newOnes[i]) {
                return true;
            } else if (stored[i] < newOnes[i]) {
                return false;
            }
        }
        return false;
    }


}
