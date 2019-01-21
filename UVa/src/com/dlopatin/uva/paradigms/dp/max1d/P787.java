package com.dlopatin.uva.paradigms.dp.max1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=728
 * Maximum Sub-sequence Product
 */
public class P787 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                StringTokenizer dataTokens = new StringTokenizer(line);
                int n = 0;
                BigInteger[][] cache = new BigInteger[105][105];
                BigInteger[] data = new BigInteger[103];
                BigInteger prod = BigInteger.valueOf(-999999);
                while (dataTokens.hasMoreTokens()) {
                    int next = parseInt(dataTokens.nextToken());
                    if (next == -999999) {
                        break;
                    }
                    BigInteger nextBig = BigInteger.valueOf(next);
                    data[n] = nextBig;
                    cache[0][n] = nextBig;
                    prod = prod.max(nextBig);
                    n++;
                }
//                for (int i = 0; i < n; i++) {
//                    BigInteger curr = BigInteger.valueOf(1);
//                    for (int j = i; j < n; j++) {
//                        curr = curr.multiply(data[j]);
//                        if (curr.compareTo(prod) > 0) {
//                            prod = curr;
//                        }
//                    }
//                }

                for (int len = 1; len < n; len++) {
                    for (int pos = 0; pos < n - len; pos++) {
                        BigInteger multiply = cache[len - 1][pos].multiply(data[pos + len]);
                        cache[len][pos] = multiply;
                        prod = prod.max(multiply);
                    }
                }
                result.append(prod).append("\n");
            }
            System.out.print(result);
        }

    }

}

