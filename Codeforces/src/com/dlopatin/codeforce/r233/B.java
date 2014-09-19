package com.dlopatin.codeforce.r233;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/399/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            char[] data = scanner.next().toCharArray();
            long sum = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] == 'B') {
                    sum += Math.pow(2, i);
                }
            }
            System.out.println(sum);
        }
    }

}
