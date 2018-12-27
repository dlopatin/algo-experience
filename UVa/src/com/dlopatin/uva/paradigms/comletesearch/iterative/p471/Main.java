package com.dlopatin.uva.paradigms.comletesearch.iterative.p471;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=361&page=show_problem&problem=412
 */
public class Main {

    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        new Main().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            for (int k = 0; k < n; k++) {
                long number = scanner.nextLong();
                final long start = 1;
                final long end = 9876543210L;
                for (long b = start; b * number <= end && b * number > 0; b++) {
                    long a = b * number;
                    if (isUnique(b) && isUnique(a)) {
                        result.append(a).append(" / ").append(b).append(" = ").append(number)
                                .append(System.lineSeparator());
                    }
                }
                result.append(System.lineSeparator());
            }
            System.out.println(result.toString().trim());
        }

    }

    private boolean isUnique(long a) {
        int[] digits = new int[CAPACITY];
        findAndFillDigits(digits, a);
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 1) {
                return false;
            }
        }
        return true;
    }

    private void findAndFillDigits(int[] digits, long number) {
        while (number != 0) {
            int digit = (int) (number % 10);
            number /= 10;
            digits[digit]++;
        }
    }

}
