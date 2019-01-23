package com.dlopatin.codeforce.div2.r533;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1105/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            StringTokenizer nk = new StringTokenizer(reader.readLine());
            int n = parseInt(nk.nextToken());
            int k = parseInt(nk.nextToken());
            int[] repeats = new int['z' - 'a' + 1];
            char[] data = reader.readLine().toCharArray();
            char prev = 0;
            int repeatCnt = 1;
            for (int i = 0; i < data.length; i++) {
                char ch = data[i];
                if (k == 1) {
                    repeats[ch - 'a']++;
                } else if (i > 0) {
                    if (prev == ch) {
                        repeatCnt++;
                        if (repeatCnt == k) {
                            repeats[ch - 'a']++;
                            repeatCnt = 0;
                        }
                    } else {
                        repeatCnt = 1;
                    }
                }
                prev = ch;
            }
            int max = repeats[0];
            for (int rep : repeats) {
                max = Math.max(max, rep);
            }

            System.out.println(max);
        }
    }
}