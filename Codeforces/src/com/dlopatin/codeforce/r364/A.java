package com.dlopatin.codeforce.r364;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/701/problem/A
 */
public class A {

    public static void main(String[] args) {
        new A().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int sum = 0;
            int array[] = new int[n];
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                array[i] = val;
                sum += val;
            }
            int v = sum / (n / 2);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (array[i] > 0) {
                    res.append(i + 1).append(" ");
                    for (int j = i + 1; j < n; j++) {
                        if (v - array[i] == array[j]) {
                            res.append(j + 1).append("\n");
                            array[j] = -1;
                            break;
                        }
                    }
                    array[i] = -1;
                }
            }
            System.out.println(res.toString().trim());
        }
    }
}