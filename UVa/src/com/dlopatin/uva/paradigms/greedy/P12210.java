package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3362
 * A Match Making Problem
 */
public class P12210 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseIdx = 1;
            while ((line = reader.readLine()) != null && !"0 0".equals(line)) {
                StringTokenizer bs = new StringTokenizer(line);
                int b = parseInt(bs.nextToken());
                int s = parseInt(bs.nextToken());
                int[] man = new int[b];
                for (int i = 0; i < b; i++) {
                    man[i] = parseInt(reader.readLine());
                }
                Arrays.sort(man);

                for (int i = 0; i < s; i++) {
                    reader.readLine();
                }

                result.append("Case ").append(caseIdx++).append(": ");
                if (b <= s) {
                    result.append(0);
                } else {
                    result.append(b - s).append(" ").append(man[0]);
                }

                result.append("\n");
            }
            System.out.print(result);
        }

    }

}
