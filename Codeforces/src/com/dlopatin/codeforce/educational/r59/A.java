package com.dlopatin.codeforce.educational.r59;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1107/problem/A
 */
public class A {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            while (q-- > 0) {
                int n = parseInt(reader.readLine());
                char[] s = reader.readLine().toCharArray();
                char first = s[0];
                if (first < s[1] || s.length > 2) {
                    result.append("YES\n")
                            .append(2).append("\n")
                            .append(first).append(" ").append(new String(s, 1, s.length - 1));
                } else {
                    result.append("NO");
                }
                result.append("\n");
            }
            System.out.print(result);
        }
    }
}