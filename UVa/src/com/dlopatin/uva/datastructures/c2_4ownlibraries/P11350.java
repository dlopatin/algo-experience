package com.dlopatin.uva.datastructures.c2_4ownlibraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=25&page=show_problem&problem=2325<p>
 * Stern-Brocot Tree
 */
public class P11350 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringResult = new StringBuilder();
            int n = parseInt(reader.readLine());
            StringBuilder res = new StringBuilder();
            while (n-- > 0) {
                res.append(binSearch(reader.readLine())).append("\n");
            }
            System.out.print(res);
        }

    }

    private static Fraction binSearch(String direction) {
        Fraction left = new Fraction(0, 1);
        Fraction right = new Fraction(1, 0);
        Fraction median = Fraction.medianOf(left, right);
        for (char ch : direction.toCharArray()) {
            if (ch == 'R') {
                left = median;
            } else {
                right = median;
            }
            median = Fraction.medianOf(left, right);
        }
        return median;
    }

    private static class Fraction {
        private final long up;
        private final long down;

        public Fraction(long up, long down) {
            this.up = up;
            this.down = down;
        }

        @Override
        public String toString() {
            return String.format("%d/%d", up, down);
        }

        public static Fraction medianOf(Fraction left, Fraction right) {
            return new Fraction((left.up + right.up), (left.down + right.down));
        }

    }


}
