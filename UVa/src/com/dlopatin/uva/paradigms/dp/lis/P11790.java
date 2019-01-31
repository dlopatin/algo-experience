package com.dlopatin.uva.paradigms.dp.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2890
 * Murcia’s Skyline
 */
public class P11790 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                int n = parseInt(reader.readLine());
                int[] height = new int[n];
                StringTokenizer heightTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    height[i] = parseInt(heightTokens.nextToken());
                }
                int[] width = new int[n];
                StringTokenizer widthTokens = new StringTokenizer(reader.readLine());
                for (int i = 0; i < n; i++) {
                    width[i] = parseInt(widthTokens.nextToken());
                }
                int maxInc = 0;
                int maxDec = 0;
                int[] lis = new int[n];
                int[] lds = new int[n];
                for (int i = 0; i < n; i++) {
                    lis[i] = width[i];
                    lds[i] = width[i];
                    for (int j = 0; j < i; j++) {
                        if (height[j] < height[i]) {
                            lis[i] = Math.max(lis[i], lis[j] + width[i]);
                        }
                        if (height[j] > height[i]) {
                            lds[i] = Math.max(lds[i], lds[j] + width[i]);
                        }
                    }
                    maxInc = Math.max(maxInc, lis[i]);
                    maxDec = Math.max(maxDec, lds[i]);
                }
                result.append("Case ").append(caseIdx).append(". ");
                if (maxInc >= maxDec) {
                    result.append(String.format("Increasing (%d). Decreasing (%d).\n", maxInc, maxDec));
                } else {
                    result.append(String.format("Decreasing (%d). Increasing (%d).\n", maxDec, maxInc));
                }
            }
            System.out.print(result);
        }
    }

}

