package com.dlopatin.uva.paradigms.comletesearch.iterative.manyloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=676
 * Dart-a-Mania
 */
public class P735 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> scoresSet = new HashSet<>();
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 3; j++) {
                    scoresSet.add(i * j);
                }
            }
            scoresSet.add(0);
            scoresSet.add(50);

            int[] scores = scoresSet.stream().mapToInt(i -> i).toArray();

            int n;
            while ((n = parseInt(reader.readLine())) > 0) {
                int comb = 0;
                int perm = 0;
                for (int a = 0; a < scores.length; a++) {
                    for (int b = 0; b < scores.length; b++) {
                        for (int c = 0; c < scores.length; c++) {
                            if (scores[a] + scores[b] + scores[c] == n) {
                                if (c >= b && b >= a) {
                                    comb++;
                                }
                                perm++;
                            }
                        }
                    }
                }

                if (comb > 0) {
                    result.append(String.format("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", n, comb));
                    result.append(String.format("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", n, perm));
                } else {
                    result.append(String.format("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", n));
                }
                result.append("**********************************************************************\n");
            }
            result.append("END OF OUTPUT");
            System.out.println(result);
        }
    }

}
