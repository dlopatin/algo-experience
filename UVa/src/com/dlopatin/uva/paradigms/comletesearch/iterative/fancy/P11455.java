package com.dlopatin.uva.paradigms.comletesearch.iterative.fancy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3886
 * Bars
 */
public class P11455 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseNumber = parseInt(reader.readLine());
            while (caseNumber-- > 0) {
                int targetSum = parseInt(reader.readLine());
                int p = parseInt(reader.readLine());
                StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                int[] data = new int[p];
                for (int i = 0; i < p; i++) {
                    data[i] = parseInt(dataTokens.nextToken());
                }

                String testResult = "NO";
                for (int subset = 0; subset <= ((1 << p) - 1); subset++) {
                    int localSum = 0;
                    for (int idx = 0; idx < p; idx++) {
                        if ((subset & (1 << idx)) > 0) {
                            localSum += data[idx];
                        }
                    }
                    if (localSum == targetSum) {
                        testResult = "YES";
                        break;
                    }
                }
                result.append(testResult).append("\n");
            }
            System.out.print(result);
        }
    }


}
