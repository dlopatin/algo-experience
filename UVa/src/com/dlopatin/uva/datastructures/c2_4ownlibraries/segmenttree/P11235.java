package com.dlopatin.uva.datastructures.c2_4ownlibraries.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2176<p>
 * Segment tree<p>
 * Frequent values
 *
 * @see <a href="https://github.com/luisfcofv/competitive-programming-book/blob/master/ch2/ch2_09_segmenttree_ds.java">LazySegmentTree</a>
 */
public class P11235 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringResult = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && !"0".equals(line)) {
                StringTokenizer amount = new StringTokenizer(line);
                int n = parseInt(amount.nextToken());
                int q = parseInt(amount.nextToken());

                int[] sequenceStart = new int[n + 2];
                int[] idxToSeq = new int[n + 2];
                List<Integer> frequencies = new ArrayList<>(n);
                int seqCnt = 0;
                StringTokenizer input = new StringTokenizer(reader.readLine());
                int prev = parseInt(input.nextToken());
                // 1-based count start
                sequenceStart[0] = 1;
                idxToSeq[1] = 0;
                for (int i = 2; i <= n; i++) {
                    int current = parseInt(input.nextToken());
                    if (current != prev) {
                        seqCnt++;
                        sequenceStart[seqCnt] = i;
                        frequencies.add(sequenceStart[seqCnt] - sequenceStart[seqCnt - 1]);
                        prev = current;
                    }
                    idxToSeq[i] = seqCnt;
                }
                seqCnt++;
                sequenceStart[seqCnt] = n + 1;
                frequencies.add(n + 1 - sequenceStart[seqCnt - 1]);

                SegmentTreeMax segTree = new SegmentTreeMax(frequencies);
                while (q-- > 0) {
                    StringTokenizer qi = new StringTokenizer(reader.readLine());
                    int i = parseInt(qi.nextToken());
                    int j = parseInt(qi.nextToken());

                    int seqStart = idxToSeq[i];
                    int seqEnd = idxToSeq[j];

                    int res;
                    if (seqStart == seqEnd) {
                        res = j - i + 1;
                    } else {
                        int left = sequenceStart[seqStart + 1] - i;
                        int right = j + 1 - sequenceStart[seqEnd];
                        int maxInSeq = segTree.rangeMaxSequence(seqStart + 1, seqEnd - 1);
                        res = max(left, max(right, maxInSeq));
                    }
                    stringResult.append(res).append("\n");
                }
            }
            System.out.print(stringResult);
        }
    }

    private static class SegmentTreeMax {
        private final int[] st; // sequences
        private final List<Integer> data;

        public SegmentTreeMax(List<Integer> data) {
            this.data = data;
            st = new int[4 * data.size()];
            build(1, 0, data.size() - 1);
        }

        public void build(int p, int l, int r) {
            if (l == r) {
                st[p] = data.get(l);
            } else {
                int mid = l + (r - l) / 2;
                build(left(p), l, mid);
                build(right(p), mid + 1, r);
                st[p] = max(st[left(p)], st[right(p)]);
            }
        }

        public int rangeMaxSequence(int i, int j) {
            return rangeMaxSequence(1, 0, data.size() - 1, i, j);
        }

        private int rangeMaxSequence(int p, int l, int r, int i, int j) {
            if (l > j || r < i) {
                return 0;
            }
            if (l >= i && r <= j) {
                return st[p];
            }
            int m = l + (r - l) / 2;
            int maxLeft = rangeMaxSequence(left(p), l, m, i, j);
            int maxRight = rangeMaxSequence(right(p), m + 1, r, i, j);
            return max(maxLeft, maxRight);
        }


        private int left(int p) {
            return p << 1;
        }

        private int right(int p) {
            return (p << 1) + 1;
        }

    }

}
