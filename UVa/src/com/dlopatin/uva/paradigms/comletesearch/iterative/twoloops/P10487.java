package com.dlopatin.uva.paradigms.comletesearch.iterative.twoloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1428
 */
public class P10487 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseId = 1;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                result.append("Case ").append(caseId++).append(":\n");
                int n = parseInt(line);
                int[] data = new int[n];
                for (int i = 0; i < n; i++) {
                    data[i] = parseInt(reader.readLine());
                }
                int qnum = parseInt(reader.readLine());
                while (qnum-- > 0) {
                    int q = parseInt(reader.readLine());
                    int sum = 0;
                    int diff = Integer.MAX_VALUE;
                    for (int i = 0; i < data.length; i++) {
                        for (int j = i + 1; j < data.length; j++) {
                            int localDiff = Math.abs((data[i] + data[j]) - q);
                            if (localDiff < diff) {
                                diff = localDiff;
                                sum = data[i] + data[j];
                            }
                        }
                    }
                    result.append(String.format("Closest sum to %d is %d.\n", q, sum));
                }
            }
            System.out.print(result);
        }
    }
}
