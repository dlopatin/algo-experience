package com.dlopatin.uva.comletesearch.backtracking.medium;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=465
 * Prime Ring Problem
 */
public class P524 {

    private static final Set<Integer> PRIME_NUMBERS = new HashSet<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    private static final List<int[]> sol = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int caseIdx = 1;
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int n = parseInt(line);
                int[] data = new int[n];
                data[0] = 1;

                sol.clear();
                backtrack(1, data);

                result.append("Case ").append(caseIdx++).append(":").append("\n");
                sol.forEach(ints -> {
                    for (int i = 0; i < ints.length; i++) {
                        result.append(ints[i]);
                        if (i != ints.length - 1) {
                            result.append(" ");
                        }
                    }
                    result.append("\n");
                });
                result.append("\n");
            }
            System.out.print(result.deleteCharAt(result.length() - 1));
        }
    }

    private static void backtrack(int idx, int[] data) {
        for (int numberToPlace = 2; numberToPlace <= data.length; numberToPlace++) {
            if (isPrime(numberToPlace + data[idx - 1]) && isNumberNotUsed(numberToPlace, idx, data)) {
                data[idx] = numberToPlace;
                if (idx == data.length - 1) {
                    if (isPrime(data[idx] + data[0])) {
                        sol.add(Arrays.copyOf(data, data.length));
                    }
                } else {
                    backtrack(idx + 1, data);
                }
            }
        }
    }

    private static boolean isNumberNotUsed(int number, int pos, int[] data) {
        for (int i = 1; i < pos; i++) {
            if (data[i] == number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int number) {
        return PRIME_NUMBERS.contains(number);
    }
}
