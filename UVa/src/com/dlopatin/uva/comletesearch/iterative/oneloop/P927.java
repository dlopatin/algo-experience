package com.dlopatin.uva.comletesearch.iterative.oneloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P927 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int cases = parseInt(reader.readLine());
            while (cases-- > 0) {
                StringTokenizer data = new StringTokenizer(reader.readLine());
                int i = parseInt(data.nextToken());
                int c[] = new int[i + 1];
                for (int idx = 0; idx < i + 1; idx++) {
                    c[idx] = parseInt(data.nextToken());
                }
                int d = parseInt(reader.readLine());
                int k = parseInt(reader.readLine());
                int n = 0;
                for (int acc = 0; acc < k; acc += d * n) {
                    n++;
                }
                result.append(func(c, i, n)).append("\n");
            }
            System.out.print(result);

        }
    }

    private static long func(int c[], int i, int n) {
        long res = 0;
        for (int j = 0; j <= i; j++) {
            res += c[j] * Math.pow(n, j);
        }
        return res;
    }
}
