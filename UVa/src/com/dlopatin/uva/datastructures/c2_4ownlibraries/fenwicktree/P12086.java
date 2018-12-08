package com.dlopatin.uva.datastructures.c2_4ownlibraries.fenwicktree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=242&page=show_problem&problem=3238<p>
 * Fenwick tree<p>
 * Potentiometers
 */
public class P12086 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            String line;
            int caseNumber = 1;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                result.append("Case ").append(caseNumber++).append(":\n");
                int n = parseInt(line);
                FenwickTree fenwickTree = new FenwickTree(n);
                for (int i = 1; i <= n; i++) {
                    fenwickTree.adjust(i, parseInt(reader.readLine()));
                }
                while (!"END".equals(line = reader.readLine())) {
                    StringTokenizer st = new StringTokenizer(line);
                    char action = st.nextToken().charAt(0);
                    int pos = parseInt(st.nextToken());
                    int posOrVal = parseInt(st.nextToken());
                    if ('S' == action) {
                        fenwickTree.set(pos, posOrVal);
                    } else {
                        result.append(fenwickTree.rsq(pos, posOrVal)).append("\n");
                    }
                }
                result.append("\n");
            }
            System.out.println(result.toString().trim());
        }
    }

    private static class FenwickTree {
        private final int[] ft;

        private FenwickTree(int n) {
            ft = new int[n + 1];
        }

        /**
         * Returns RSQ(1, pos)
         *
         * @param pos end position
         * @return range sum query
         */
        public int rsq(int pos) {
            int sum = 0;
            while (pos > 0) {
                sum += ft[pos];
                pos -= lsOne(pos);
            }
            return sum;
        }

        public int rsq(int a, int b) {
            return rsq(b) - (a == 1 ? 0 : rsq(a - 1));
        }

        public void set(int pos, int val) {
            adjust(pos, val - rsq(pos, pos));
        }

        public void adjust(int pos, int val) {
            while (pos < ft.length) {
                ft[pos] += val;
                pos += lsOne(pos);
            }
        }

        // returns last significant bit
        private int lsOne(int v) {
            return v & (-v);
        }
    }

}
