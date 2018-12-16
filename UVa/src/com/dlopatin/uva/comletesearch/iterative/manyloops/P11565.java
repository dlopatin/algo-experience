package com.dlopatin.uva.comletesearch.iterative.manyloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2612
 * Simple Equations
 */
public class P11565 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int n = parseInt(reader.readLine());
            while (n-- > 0) {
                StringTokenizer data = new StringTokenizer(reader.readLine());
                int a = parseInt(data.nextToken());
                int b = parseInt(data.nextToken());
                int c = parseInt(data.nextToken());
                String solution = null;
                for (int x = -22; 3 * x <= a && x <= 22; x++) { // 22 = cubic root of 10 000
                    for (int y = x + 1; x + 2 * y <= a && y <= 100; y++) { // 100 = square root of 10 000 if x = 1
                        for (int z = y + 1; x + y + z <= a; z++) {
                            if (x + y + z == a && x * y * z == b && x * x + y * y + z * z == c) {
                                solution = String.format("%d %d %d\n", x, y, z);
                                break;
                            }
                        }
                    }
                }
                result.append(solution == null ? "No solution.\n" : solution);
            }
            System.out.print(result);
        }
    }


}
