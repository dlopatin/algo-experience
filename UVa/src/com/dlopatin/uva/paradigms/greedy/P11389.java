package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2384
 * The Bus Driver Problem
 */
public class P11389 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0 0 0".equals(line)) {
                StringTokenizer ndr = new StringTokenizer(line);
                int n = parseInt(ndr.nextToken());
                int d = parseInt(ndr.nextToken());
                int r = parseInt(ndr.nextToken());
                int[] morning = new int[n];
                StringTokenizer morningTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    morning[i] = parseInt(morningTokens.nextToken());
                }
                int[] evening = new int[n];
                StringTokenizer eveningTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    evening[i] = parseInt(eveningTokens.nextToken());
                }
                Arrays.sort(morning);
                Arrays.sort(evening);
                int overtime = 0;
                for (int i = 0; i < n; i++) {
                    int sum = morning[i] + evening[n - 1 - i];
                    if (sum > d) {
                        overtime += sum - d;
                    }
                }
                result.append(overtime * r).append("\n");
            }
            System.out.print(result);
        }

    }

}
