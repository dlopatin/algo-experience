package com.dlopatin.codeforce.div2.r532;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1100/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nk = new StringTokenizer(reader.readLine());
            int n = parseInt(nk.nextToken());
            int k = parseInt(nk.nextToken());
            int[] data = new int[n];
            StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                data[i] = parseInt(dataTokens.nextToken());
            }

            int maxSum = 0;
            for (int i = 0; i < k; i++) {
                int sum = 0;
                for (int j = 0; j < data.length; j++) {
                    if ((j - i) % k != 0) {
                        sum += data[j];
                    }
                }
                maxSum = Math.max(maxSum, Math.abs(sum));
            }
            System.out.println(maxSum);
        }
    }
}