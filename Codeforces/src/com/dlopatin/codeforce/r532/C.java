package com.dlopatin.codeforce.r532;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * http://codeforces.com/contest/1100/problem/C
 */
public class C {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            StringTokenizer nr = new StringTokenizer(reader.readLine());
            int n = parseInt(nr.nextToken());
            double r = parseDouble(nr.nextToken());

            double lo = 0;
            double hi = 1_000;
            double mid = 0;
            for (int i = 0; i <= 34; i++) { // log2(10^10) = 33.219
                mid = lo + (hi - lo) / 2.0;
                if (can(mid, r, n)) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            System.out.printf("%.7f", mid);
        }
    }

    private static boolean can(double R, double r, int n) {
        double betta = 360.0 / n;
        double a = r + R;
        double b = 2 * a * Math.sin(Math.toRadians(betta / 2));
        return (R + R >= b) && (R + b >= R);
    }
}