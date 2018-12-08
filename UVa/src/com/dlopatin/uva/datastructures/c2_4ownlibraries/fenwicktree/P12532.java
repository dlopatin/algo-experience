package com.dlopatin.uva.datastructures.c2_4ownlibraries.fenwicktree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=441&page=show_problem&problem=3977<p>
 * Fenwick tree<p>
 * Interval Product
 */
public class P12532 {

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String nk;
            while ((nk = reader.readLine()) != null && !nk.isEmpty()) {
                StringTokenizer nkTokens = new StringTokenizer(nk);
                int n = parseInt(nkTokens.nextToken());
                int k = parseInt(nkTokens.nextToken());

                FenwickTree negative = new FenwickTree(n);
                FenwickTree zeros = new FenwickTree(n);
                int[] data = new int[n];
                StringTokenizer initialVals = new StringTokenizer(reader.readLine());
                for (int i = 1; i <= n; i++) {
                    int val = parseInt(initialVals.nextToken());
                    data[i - 1] = val;
                    if (val < 0) {
                        negative.adjust(i, 1);
                    } else if (val == 0) {
                        zeros.adjust(i, 1);
                    }
                }

                while (k-- > 0) {
                    StringTokenizer queryTokens = new StringTokenizer(reader.readLine());
                    char action = queryTokens.nextToken().charAt(0);
                    int a = parseInt(queryTokens.nextToken());
                    int bOrVal = parseInt(queryTokens.nextToken());
                    if (action == 'C') {
                        int prev = data[a - 1];
                        if (prev != bOrVal && !(prev < 0 && bOrVal < 0) && !(prev > 0 && bOrVal > 0)) {
                            data[a - 1] = bOrVal;
                            if (prev < 0) {
                                negative.adjust(a, -1);
                            } else if (prev == 0) {
                                zeros.adjust(a, -1);
                            }

                            if (bOrVal == 0) {
                                zeros.adjust(a, 1);
                            } else if (bOrVal < 0) {
                                negative.adjust(a, 1);
                            }
                        }
                    } else {
                        if (zeros.rsq(a, bOrVal) > 0) {
                            result.append('0');
                        } else {
                            int negativeCnt = negative.rsq(a, bOrVal);
                            result.append(negativeCnt % 2 == 0 ? '+' : '-');
                        }
                    }
                }
                result.append("\n");
            }
            System.out.print(result);
        }
    }

    private static class FenwickTree {
        private final int[] ft;

        public FenwickTree(int n) {
            ft = new int[n + 1];
        }

        // from 1 to idx
        public int rsq(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += ft[idx];
                idx -= lsOne(idx);
            }
            return sum;
        }

        public int rsq(int a, int b) {
            return rsq(b) - (a == 1 ? 0 : rsq(a - 1));
        }

        public int getVal(int idx) {
            return rsq(idx, idx);
        }

        public void set(int pos, int val) {
            adjust(pos, val - getVal(pos));
        }

        public void adjust(int pos, int diff) {
            while (pos < ft.length) {
                ft[pos] += diff;
                pos += lsOne(pos);
            }
        }

        private int lsOne(int idx) {
            return idx & -idx;
        }
    }
}
