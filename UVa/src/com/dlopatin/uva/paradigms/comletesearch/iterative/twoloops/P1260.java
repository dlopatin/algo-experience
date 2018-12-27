package com.dlopatin.uva.paradigms.comletesearch.iterative.twoloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3701
 */
public class P1260 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                StringTokenizer tokens = new StringTokenizer(reader.readLine());
                int[] data = new int[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    data[i] = parseInt(tokens.nextToken());
                    for (int j = 0; j < i; j++) {
                        if (data[j] <= data[i]) {
                            sum++;
                        }
                    }
                }
                result.append(sum).append("\n");
            }
            System.out.print(result);
        }
    }
}
