package com.dlopatin.codeforce.div2.r236;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/402/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int val = 0;
            for (int v = 1; v <= 1000; v++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j] != v + j * k) {
                        cnt++;
                    }
                }
                if (cnt < min) {
                    val = v;
                    min = cnt;
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int expectedVal = val + i * k;
                if (expectedVal > a[i]) {
                    res.append("+ ").append(i + 1).append(" ").append(expectedVal - a[i])
                            .append(System.lineSeparator());
                } else if (expectedVal < a[i]) {
                    res.append("- ").append(i + 1).append(" ").append(a[i] - expectedVal)
                            .append(System.lineSeparator());
                }
            }
            System.out.println(min);
            System.out.println(res.toString());
        }
    }

}
