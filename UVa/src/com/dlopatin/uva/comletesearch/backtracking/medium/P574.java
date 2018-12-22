package com.dlopatin.uva.comletesearch.backtracking.medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=515
 * Sum It Up
 */
public class P574 {

    private static final Set<String> sol = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer tokens = new StringTokenizer(line);
                int total = parseInt(tokens.nextToken());
                int n = parseInt(tokens.nextToken());
                int maxSum = 0;
                int[] data = new int[n];
                for (int i = 0; i < data.length; i++) {
                    int value = parseInt(tokens.nextToken());
                    data[i] = value;
                    maxSum += value;
                }

                sol.clear();
                if (data[n - 1] <= total && maxSum >= total) {
                    backtrack(0, 0, new boolean[n], total, data);
                }

                result.append("Sums of ").append(total).append(":").append("\n");
                if (sol.isEmpty()) {
                    result.append("NONE\n");
                } else {
                    sol.forEach(solution -> {
                        result.append(solution).append("\n");
                    });
                }
            }
            System.out.print(result);
        }
    }

    private static void backtrack(int idx, int sum, boolean[] used, int total, int[] data) {
        for (int nextIdx = idx; nextIdx < data.length && sum + data[idx] * data.length - idx >= total; nextIdx++) {
            int currentSum = sum + data[nextIdx];
            if (currentSum <= total) {
                used[nextIdx] = true;
                if (currentSum == total) {
                    addSolution(used, data);
                } else {
                    backtrack(nextIdx + 1, currentSum, used, total, data);
                }
                used[nextIdx] = false;
            }
        }
    }

    private static void addSolution(boolean[] used, int[] data) {
        StringBuilder localSolution = new StringBuilder();
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                if (localSolution.length() > 0) {
                    localSolution.append("+");
                }
                localSolution.append(data[i]);
            }
        }
        sol.add(localSolution.toString());
    }
}
