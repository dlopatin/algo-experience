package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3836
 * Scarecrow
 */
public class P12405 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                int n = parseInt(reader.readLine());
                char[] data = reader.readLine().toCharArray();
                int cnt = 0;
                int idx = 0;
                while (idx < data.length) {
                    char cell = data[idx];
                    if ('.' == cell) {
                        cnt++;
                        idx += 3;
                    } else {
                        idx++;
                    }
                }
                result.append(String.format("Case %d: %d\n", caseIdx, cnt));
            }
            System.out.print(result);
        }

    }

}
