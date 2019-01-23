package com.dlopatin.codeforce.div2.r359;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/686/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            boolean sorted = false;
            StringBuilder res = new StringBuilder();
            while (!sorted) {
                int l = n + 1;
                int r = -1;
                sorted = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        if (l > i) {
                            l = i;
                        }
                        if (r < i) {
                            r = i + 1;
                        }
                        int tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                        sorted = false;
                        i++;
                    } else if (!sorted) {
                        break;
                    }
                }
                if (!sorted) {
                    res.append(String.format("%d %d\n", l + 1, r + 1));
                }
            }
            System.out.println(res);
        }
    }
}