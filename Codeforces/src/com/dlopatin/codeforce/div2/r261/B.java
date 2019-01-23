package com.dlopatin.codeforce.div2.r261;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Long> flowers = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                flowers.add(scanner.nextLong());
            }
            long max = 0;
            long min = Long.MAX_VALUE;
            long maxCount = 0;
            long minCount = 0;
            for (long val : flowers) {
                if (val == max) {
                    maxCount++;
                }
                if (val > max) {
                    max = val;
                    maxCount = 1;
                }
                if (val == min) {
                    minCount++;
                }
                if (val < min) {
                    min = val;
                    minCount = 1;
                }
            }
            System.out.print(max - min);
            System.out.print(" ");
            System.out.print(maxCount != minCount ? maxCount * minCount : findCombination(minCount));

        }

    }

    private int findCombination(long n) {
        int k = 2;
        return n > 1 ? factorial(n) / (k * factorial(n - k)) : 1;
    }

    private int factorial(long n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
