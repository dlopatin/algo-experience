package com.dlopatin.uva.comletesearch.iterative.oneloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1917
 */
public class P10976 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int k = parseInt(line);
                /* x can be found by k * y / (y - k);
                 * max for x and y is 2k = 1/2k+1/2k
                 * Then larger x, then y is smaller, since y can't be k, then start point is k + 1
                 * So. we have interval for y=[k+1, 2k]
                 */

                StringBuilder tempRes = new StringBuilder();
                int count = 0;
                for (int y = k + 1; y <= 2 * k; y++) {
                    if (k * y % (y - k) == 0) {
                        count++;
                        int x = k * y / (y - k);
                        tempRes.append(String.format("1/%d = 1/%d + 1/%d\n", k, x, y));
                    }
                }
                result.append(count).append("\n").append(tempRes);
            }
            System.out.print(result);
        }
    }

}
