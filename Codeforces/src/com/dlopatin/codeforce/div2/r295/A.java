package com.dlopatin.codeforce.div2.r295;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * http://codeforces.com/contest/520/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {

            Set<Character> set = new HashSet<>();
            int n = scanner.nextInt();
            char[] array = scanner.next().toCharArray();
            for (int i = 0; i < n; i++) {
                set.add(Character.toLowerCase(array[i]));
            }
            String res = "NO";
            if (set.size() >= 26) {
                res = "YES";
            }
            System.out.println(res);
        }
    }

}
