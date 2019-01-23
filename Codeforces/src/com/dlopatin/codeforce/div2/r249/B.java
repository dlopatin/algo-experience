package com.dlopatin.codeforce.div2.r249;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws IOException, ParseException {
        new B().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            char[] digits = scanner.next().toCharArray();
            int tries = scanner.nextInt();
            int shift = 0;

            while (tries > 0 && shift < digits.length) {
                int indexMax = 0;
                int max = 0;
                int len = ((tries + shift) >= digits.length) ? digits.length : tries + shift + 1;

                for (int i = shift; i < len; i++) {
                    if (digits[i] > max) {
                        max = digits[i];
                        indexMax = i;
                    }
                }

                for (int i = indexMax - 1; i >= shift && tries > 0; i--) {
                    char temp = digits[i + 1];
                    digits[i + 1] = digits[i];
                    digits[i] = temp;
                    --tries;
                }
                ++shift;
            }
            System.out.println(String.valueOf(digits));

        }
    }

}
