package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2041
 * The Trip, 2007
 */
public class P11000 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                int n = parseInt(line);
                int[] data = new int[n];
                StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    if (!dataTokens.hasMoreTokens()) {
                        dataTokens = new StringTokenizer(reader.readLine());
                    }
                    int bagSize = parseInt(dataTokens.nextToken());
                    data[i] = bagSize;

                }
                Arrays.sort(data);

                int maxSeq = 0;
                int seq = 1;
                for (int i = 0; i < data.length - 1; i++) {
                    if (data[i] == data[i + 1]) {
                        seq++;
                    } else {
                        maxSeq = Math.max(maxSeq, seq);
                        seq = 1;
                    }
                }
                maxSeq = Math.max(maxSeq, seq);

                result.append(maxSeq).append("\n");
                for (int i = 0; i < maxSeq; i++) {
                    for (int j = i; j < n; j += maxSeq) {
                        result.append(data[j]).append(" ");
                    }
                    result.deleteCharAt(result.length() - 1);
                    result.append("\n");
                }
                result.append("\n");
            }
            System.out.print(result);
        }

    }

}
