package com.dlopatin.codeforce.div2.r536;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * http://codeforces.com/contest/1106/problem/C
 */
public class C {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            long[] data = new long[n];
            StringTokenizer dataTokens = new StringTokenizer(reader.readLine());
            for (int i = 0; i < data.length; i++) {
                data[i] = parseLong(dataTokens.nextToken());
            }
            Arrays.sort(data);
            long sum = 0;
            for (int i = 0; i < n / 2; i++) {
                long a = data[i] + data[n - 1 - i];
                sum += a * a;
            }
            System.out.println(sum);
        }
    }


}