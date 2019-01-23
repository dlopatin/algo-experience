package com.dlopatin.codeforce.div2.r533;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1105/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            int[] data = new int[n];
            StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = parseInt(dataTokens.nextToken());
                data[i] = num;
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            int bestT = data[n - 1];
            int cost = Integer.MAX_VALUE;
            for (int t = min; t <= max && cost != 0; t++) {
                int localCost = 0;
                for (int d : data) {
                    int diff = Math.abs(t - d);
                    if (diff > 1) {
                        localCost += diff - 1;
                    }
                }
                if (localCost < cost) {
                    bestT = t;
                    cost = localCost;
                }
            }

            System.out.println(String.format("%d %d", bestT, cost));
        }
    }
}