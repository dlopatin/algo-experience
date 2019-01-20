package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2098
 * Dynamic Frog
 */
public class P11157 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                StringTokenizer ndTokens = new StringTokenizer(reader.readLine());
                int n = parseInt(ndTokens.nextToken());
                int d = parseInt(ndTokens.nextToken());
                int[][] data = new int[n + 4][2];
                data[0][0] = 'B';
                StringTokenizer dataTokens = new StringTokenizer(reader.readLine(), " \t\n\r\f-");
                for (int i = 1; i <= n; i++) {
                    data[i][0] = dataTokens.nextToken().charAt(0);
                    data[i][1] = parseInt(dataTokens.nextToken());
                }
                for (int i = n + 1; i <= n + 3; i++) {
                    data[i][0] = 'B';
                    data[i][1] = d;
                }

                int minMax = 0;
                for (int i = 0; i < data.length - 2; i++) {
                    if (data[i + 1][0] == 'B') {
                        minMax = Math.max(data[i + 1][1] - data[i][1], minMax);
                    } else {
                        minMax = Math.max(data[i + 2][1] - data[i][1], minMax);
                    }
                }
                result.append(String.format("Case %d: %d\n", caseIdx, minMax));
            }
            System.out.print(result);
        }

    }

}
