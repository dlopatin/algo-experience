package com.dlopatin.codeforce.div2.r536;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1106/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            boolean[][] data = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                char[] input = reader.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    data[i][j] = 'X' == input[j];
                }
            }
            int cnt = 0;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (data[i][j] && data[i - 1][j - 1] && data[i - 1][j + 1]
                            && data[i + 1][j - 1] && data[i + 1][j + 1]) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}