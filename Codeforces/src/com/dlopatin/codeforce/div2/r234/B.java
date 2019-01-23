package com.dlopatin.codeforce.div2.r234;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.ru/contest/400/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] diff = new int[m];
            for (int i = 0; i < n; i++) {
                char[] line = scanner.next().toCharArray();
                int g = 0;
                int s = 0;
                for (int j = 0; j < m; j++) {
                    if (line[j] == 'G') {
                        g = j;
                    } else if (line[j] == 'S') {
                        s = j;
                    }
                }
                int steps = s - g;
                if (steps < 0) {
                    System.out.println(-1);
                    return;
                }
                diff[steps] = 1;
            }
            int count = 0;
            for (int i : diff) {
                if (i == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
