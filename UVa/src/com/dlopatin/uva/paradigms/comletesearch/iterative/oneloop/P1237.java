package com.dlopatin.uva.paradigms.comletesearch.iterative.oneloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3678
 */
public class P1237 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                Data[] data = new Data[n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer input = new StringTokenizer(reader.readLine());
                    data[i] = new Data(input.nextToken(), parseInt(input.nextToken()), parseInt(input.nextToken()));
                }

                int q = parseInt(reader.readLine());
                while (q-- > 0) {
                    Data found = null;
                    int p = parseInt(reader.readLine());
                    for (Data model : data) {
                        if (model.low <= p && p <= model.high) {
                            if (found != null) {
                                found = null;
                                break;
                            }
                            found = model;
                        }
                    }
                    result.append(found == null ? "UNDETERMINED" : found.maker).append("\n");
                }
                result.append("\n");
            }
            System.out.println(result.toString().trim());
        }
    }

    private static class Data {
        private final String maker;
        private final int low;
        private final int high;

        public Data(String maker, int low, int high) {
            this.maker = maker;
            this.low = low;
            this.high = high;
        }


    }
}
