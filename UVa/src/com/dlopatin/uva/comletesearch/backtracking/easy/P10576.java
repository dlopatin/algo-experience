package com.dlopatin.uva.comletesearch.backtracking.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1517
 * Y2K Accounting Bug
 */
public class P10576 {

    private static int bestSum = Integer.MIN_VALUE;
    private static int[] months;

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer tokens = new StringTokenizer(line);
                int profit = parseInt(tokens.nextToken());
                int deficit = parseInt(tokens.nextToken());
                bestSum = Integer.MIN_VALUE;
                months = new int[12];

                backtrack(0, 0, 0, profit, deficit);
                result.append(bestSum < 0 ? "Deficit" : bestSum).append("\n");
            }
            System.out.print(result);
        }
    }

    private static void backtrack(int idx, int sum, int sumLast5Mos, int profit, int deficit) {
        if (idx == 12) {
            if (bestSum < sum) {
                bestSum = sum;
            }
            return;
        }
        if (idx >= 5) {
            if (sumLast5Mos >= 0) {
                // prune this case as report is positive
                return;
            }
            sumLast5Mos = sumLast5Mos - months[idx - 5];
        }
        if (idx < 4 || sumLast5Mos + profit < 0) {
            // try to add profit
            months[idx] = profit;
            backtrack(idx + 1, sum + profit, sumLast5Mos + profit, profit, deficit);
        }
        // try deficit
        months[idx] = -deficit;
        backtrack(idx + 1, sum - deficit, sumLast5Mos - deficit, profit, deficit);
    }
}
