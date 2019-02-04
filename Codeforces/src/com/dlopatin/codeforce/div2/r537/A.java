package com.dlopatin.codeforce.div2.r537;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://codeforces.com/contest/1111/problem/A
 */
public class A {

    private static final Set<Character> A = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] s1 = reader.readLine().toCharArray();
            char[] s2 = reader.readLine().toCharArray();
            boolean res = true;
            if (s1.length != s2.length) {
                res = false;
            } else {
                for (int i = 0; i < s1.length; i++) {
                    if (A.contains(s1[i]) != A.contains(s2[i])) {
                        res = false;
                        break;
                    }
                }
            }
            System.out.println(res ? "Yes" : "No");
        }
    }
}