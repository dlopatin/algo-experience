package com.dlopatin.codeforce.div2.r297;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/525/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            char[] line = scanner.next().toCharArray();
            int m = scanner.nextInt();
            int[] counter = new int[line.length / 2];
            for (int i = 0; i < m; i++) {
                counter[scanner.nextInt() - 1]++;
            }
            int[] sum = new int[line.length / 2];

            for (int i = 0; i < counter.length; i++) {
                if (i == 0) {
                    sum[i] = counter[i];
                } else {
                    sum[i] = sum[i - 1] + counter[i];
                }

                if (sum[i] % 2 != 0) {
                    char tmp = line[i];
                    int j = line.length - i - 1;
                    line[i] = line[j];
                    line[j] = tmp;
                }
            }
            System.out.println(line);
        }
    }
}