package com.dlopatin.codeforce.educational.r59;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/**
 * http://codeforces.com/contest/1107/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = parseInt(reader.readLine());
            StringBuilder result = new StringBuilder();
            while (q-- > 0) {
                StringTokenizer data = new StringTokenizer(reader.readLine());
                long k = parseLong(data.nextToken());
                int x = parseInt(data.nextToken());
                result.append((k - 1) * 9 + x).append("\n");
            }
            System.out.print(result);
        }
    }
}