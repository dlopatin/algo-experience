package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3183
 * The Monkey and the Oiled Bamboo
 */
public class P12032 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int t = parseInt(reader.readLine());
            for (int caseIdx = 1; caseIdx <= t; caseIdx++) {
                int n = parseInt(reader.readLine());
                StringTokenizer rTokens = new StringTokenizer(reader.readLine());
                int[] rungs = new int[n];
                int diff = 0;
                for (int i = 0; i < n; i++) {
                    int r = parseInt(rTokens.nextToken());
                    rungs[i] = r;
                    if (i > 0) {
                        diff = Math.max(diff, r - rungs[i - 1]);
                    }
                }

                int lo = diff;
                int hi = rungs[rungs.length - 1];
                int k = 0;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (can(mid, rungs)) {
                        k = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                result.append("Case ").append(caseIdx).append(": ").append(k).append("\n");
            }
            System.out.print(result);
        }
    }


    private static boolean can(int k, int[] rungs) {
        int prev = 0;
        for (int rung : rungs) {
            int distance = rung - prev;
            if (distance > k) {
                return false;
            }
            if (distance == k) {
                k--;
            }
            prev = rung;
        }
        return k >= 0;
    }


}
