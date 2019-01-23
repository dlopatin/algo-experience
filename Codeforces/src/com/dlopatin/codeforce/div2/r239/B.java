package com.dlopatin.codeforce.div2.r239;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.ru/contest/408/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            char[] n = scanner.next().toCharArray();
            char[] m = scanner.next().toCharArray();
            int size = 'z' - 'a' + 1;
            int[] countN = new int[size];
            char a = 'a';
            for (int i = 0; i < n.length; i++) {
                countN[n[i] - a]++;

            }
            int[] countM = new int[size];
            for (int i = 0; i < m.length; i++) {
                countM[m[i] - a]++;
            }
            int sum = 0;
            for (int i = 0; i < size; i++) {
                if (countM[i] > 0 && countN[i] == 0) {
                    sum = -1;
                    break;
                }
                sum += Math.min(countM[i], countN[i]);

            }
            System.out.println(sum);
        }
    }

}
