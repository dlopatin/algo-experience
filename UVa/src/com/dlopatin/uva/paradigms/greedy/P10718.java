package com.dlopatin.uva.paradigms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1659
 * Bit Mask
 * https://gsourcecode.wordpress.com/2012/07/15/10718-bit-mask
 */
public class P10718 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer tokens = new StringTokenizer(line);
                long n = parseLong(tokens.nextToken());
                long l = parseLong(tokens.nextToken());
                long u = parseLong(tokens.nextToken());

                long best = ~n;
                long mask = 0;
                for (long i = 1L << 32; i > 0; i >>= 1) {
                    long tempMask = mask | i;
                    if (tempMask <= l || (tempMask <= u && (best & i) > 0)) {
                        mask = tempMask;
                    }
                }
                result.append(mask);
                result.append("\n");
            }
            System.out.print(result);
        }

    }

    private static int getNumberOfBits(long number) {
        int bitsNumber = (int) (Math.log(number) / Math.log(2));
        if ((1L << bitsNumber) - 1 != number) {
            return bitsNumber + 1;
        }
        return bitsNumber;
    }

    private static String longToBinaryString(long number, int groupSize) {
        StringBuilder result = new StringBuilder();

        for (int i = 63; i >= 0; i--) {
            long mask = 1L << i;
            result.append((number & mask) != 0 ? "1" : "0");

            if (i % groupSize == 0) {
                result.append(" ");
            }
        }
        result.replace(result.length() - 1, result.length(), "");

        return result.toString();
    }

}
