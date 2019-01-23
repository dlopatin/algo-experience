package com.dlopatin.codeforce.div2.r232;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.ru/contest/401/problem/B
 */
public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            int[] ids = new int[x - 1];
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (scanner.nextInt() == 1) {
                    int id = scanner.nextInt();
                    ids[id - 1] = id;
                    count++;
                }
                int id = scanner.nextInt();
                ids[id - 1] = 1;
                count++;
            }

            int min = 0;
            int ordered = 0;
            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == 0) {
                    ordered++;
                } else {
                    min += ordered / 2;
                    min += ordered % 2;
                    ordered = 0;
                }
            }
            min += ordered / 2;
            min += ordered % 2;
            System.out.println(min + " " + (x - count - 1));
        }
    }

}
