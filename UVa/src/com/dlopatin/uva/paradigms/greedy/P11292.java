package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2267
 * Dragon of Loowater
 */
public class P11292 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer nm = new StringTokenizer(line);
                int n = parseInt(nm.nextToken());
                int m = parseInt(nm.nextToken());
                int[] dragon = new int[n];
                for (int i = 0; i < n; i++) {
                    dragon[i] = parseInt(reader.readLine());
                }
                Arrays.sort(dragon);

                int[] knights = new int[m];
                for (int i = 0; i < m; i++) {
                    knights[i] = parseInt(reader.readLine());
                }
                Arrays.sort(knights);

                int k = 0;
                int d = 0;
                int gold = 0;
                while (k < m && d < n) {
                    while (k < m && dragon[d] > knights[k]) {
                        k++;
                    }
                    if (k == m) {
                        break;
                    }
                    gold += knights[k];
                    k++;
                    d++;
                }

                result.append(n == d ? gold : "Loowater is doomed!").append("\n");
            }
            System.out.print(result);
        }

    }

}
