package com.dlopatin.codeforce.div2.r293;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/518/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            char[] a = scanner.next().toLowerCase().toCharArray();
            char[] b = scanner.next().toLowerCase().toCharArray();
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] != 'z') {
                    a[i]++;
                    break;
                } else {
                    a[i] = 'a';
                }
            }
            if (Arrays.toString(a).compareTo(Arrays.toString(b)) >= 0) {
                System.out.println("No such string");
            } else {
                StringBuilder builder = new StringBuilder();
                for (char ch : a) {
                    builder.append(ch);
                }
                System.out.println(builder);
            }
        }
    }

}
