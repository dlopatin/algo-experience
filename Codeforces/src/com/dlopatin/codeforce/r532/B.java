package com.dlopatin.codeforce.r532;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1100/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            StringTokenizer nm = new StringTokenizer(reader.readLine());
            int n = parseInt(nm.nextToken());
            int m = parseInt(nm.nextToken());
            int[] duplicates = new int[n + 1];
            Set<Integer> group = new HashSet<>();
            StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                int complexity = parseInt(dataTokens.nextToken());
                duplicates[complexity]++;
                group.add(complexity);
                if (group.size() == n) {
                    result.append('1');
                    for (int j = 1; j < duplicates.length; j++) {
                        if (--duplicates[j] == 0) {
                            group.remove(j);
                        }
                    }
                } else {
                    result.append('0');
                }
            }

            System.out.println(result);
        }
    }
}