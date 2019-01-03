package com.dlopatin.uva.paradigms.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1282
 * Solve it
 */
public class P10341 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer data = new StringTokenizer(line);
                int p = parseInt(data.nextToken());
                int q = parseInt(data.nextToken());
                int r = parseInt(data.nextToken());
                int s = parseInt(data.nextToken());
                int t = parseInt(data.nextToken());
                int u = parseInt(data.nextToken());
                double x = biSection(p, q, r, s, t, u);
//                System.out.println("x = " + x);
//                System.out.println("f = " + f(x, p, q, r, s, t, u));
                if (Math.abs(f(x, p, q, r, s, t, u)) > 1e-4) {
                    result.append("No solution");
                } else {
                    result.append(String.format("%.4f", x));
                }
                result.append("\n");
            }
            System.out.print(result);
        }

    }

    private static double biSection(int p, int q, int r, int s, int t, int u) {
        double lo = 0.0;
        double hi = 1.0;
        double mid = 0.0;
        for (int i = 0; i <= 30; i++) { // log2(10^9) = 29.897
            mid = lo + (hi - lo) / 2.0;
            if (f(mid, p, q, r, s, t, u) > 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return mid;
    }

    private static double f(double x, int p, int q, int r, int s, int t, int u) {
        // p ∗ e^−x + q ∗ sin(x) + r ∗ cos(x) + s ∗ tan(x) + t ∗ x^2 + u = 0
        return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * Math.pow(x, 2) + u;
    }


}
