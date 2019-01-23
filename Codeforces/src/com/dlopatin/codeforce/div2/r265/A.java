package com.dlopatin.codeforce.div2.r265;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/465/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            char[] array = scanner.next().toCharArray();
            int count = 0;
            for (int i = 0; i < n; i++) {
                count++;
                if (array[i] == '0') {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
