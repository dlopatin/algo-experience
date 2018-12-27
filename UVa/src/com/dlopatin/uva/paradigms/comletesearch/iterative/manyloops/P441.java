package com.dlopatin.uva.paradigms.comletesearch.iterative.manyloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=382
 * Lotto
 */
public class P441 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                StringTokenizer data = new StringTokenizer(line);
                int k = parseInt(data.nextToken());
                int[] array = new int[k];
                for (int i = 0; i < k; i++) {
                    array[i] = parseInt(data.nextToken());
                }
                for (int a = 0; a < k - 5; a++) {
                    for (int b = a + 1; b < k - 4; b++) {
                        for (int c = b + 1; c < k - 3; c++) {
                            for (int d = c + 1; d < k - 2; d++) {
                                for (int e = d + 1; e < k - 1; e++) {
                                    for (int f = e + 1; f < k; f++) {
                                        result.append(String.format("%d %d %d %d %d %d\n",
                                                array[a], array[b], array[c], array[d], array[e], array[f]));
                                    }
                                }
                            }
                        }
                    }
                }
                result.append("\n");
            }
            System.out.println(result.toString().trim());
        }
    }

}
