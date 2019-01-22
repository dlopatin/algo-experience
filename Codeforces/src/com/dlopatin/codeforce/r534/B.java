package com.dlopatin.codeforce.r534;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://codeforces.com/contest/1104/problem/B
 */
public class B {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder data = new StringBuilder(reader.readLine());
            int cnt = 0;
            for (int i = 0; i < data.length() - 1; i++) {
                while (i < data.length() - 1 && data.charAt(i) == data.charAt(i + 1)) {
                    cnt++;
                    data.delete(i, i + 2);
                    if (i > 0) {
                        i--;
                    }
                }
            }
            boolean firstWins = cnt % 2 != 0;
            System.out.println(firstWins ? "Yes" : "No");
        }
    }
}