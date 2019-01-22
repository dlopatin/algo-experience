package com.dlopatin.codeforce.r534;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1104/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append("1 ");
            }
            System.out.printf("%d\n%s\n", n, result.deleteCharAt(result.length() - 1));
        }
    }
}