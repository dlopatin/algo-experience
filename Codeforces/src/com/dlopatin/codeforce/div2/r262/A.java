package com.dlopatin.codeforce.div2.r262;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/460/problem/A
 */
public class A {

    public static void main(String[] args) throws IOException, ParseException {
        new A().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int bought = n / m;
            int last = n % m;
            int count = n;
            while (bought > 0) {
                count += bought;
                int left = bought + last;
                bought = left / m;
                last = left % m;
            }
            System.out.println(count);
        }
    }

}
