package com.dlopatin.uva.datastructures.c2_4ownlibraries.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=247&page=show_problem&problem=3673<p>
 * Segment tree<p>
 * SKYLINE
 *
 * @see <a href="https://github.com/luisfcofv/competitive-programming-book/blob/master/ch2/ch2_09_segmenttree_ds.java">SegmentTree</a>
 */
public class P01232 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = parseInt(reader.readLine());
            while (t-- > 0) {
                int n = parseInt(reader.readLine());
                SegmentTreeMax segmentTree = new SegmentTreeMax();
                while (n-- > 0) {
                    StringTokenizer data = new StringTokenizer(reader.readLine());
                    segmentTree.updateRange(parseInt(data.nextToken()), parseInt(data.nextToken()) - 1, parseInt(data.nextToken()));
                }
                System.out.println(segmentTree.getCount());
            }
        }
    }

    private static class SegmentTreeMax {
        // data range 0 < data ≤ 10^9
        // left, right range (0 ≤ l < r ≤ 100000)
        private final static int N = 100000;
        private final int[] st;
        private int count = 0;

        public SegmentTreeMax() {
            st = new int[4 * (N + 1)];
        }

        public void updateRange(int i, int j, int val) {
            updateRange(1, 0, N, i, j, val);
        }

        private void updateRange(int p, int l, int r, int i, int j, int val) {
            // if the current interval does not intersect
            if (i > r || j < l || l > r) {
                return;
            }

            // min in range is higher than value
            if (l >= i && r <= j) {
                if (st[p] > val) {
                    return;
                }
            }

            // Current node is a leaf node
            if (l == r) {
                if (st[p] <= val) {
                    count++;
                    st[p] = val;
                }
                return;
            }

            // If not a leaf node, recur for children.
            int mid = l + (r - l) / 2;
            updateRange(left(p), l, mid, i, j, val);
            updateRange(right(p), mid + 1, r, i, j, val);

            st[p] = min(st[left(p)], st[right(p)]);
        }

        public int getCount() {
            return count;
        }

        private int left(int p) {
            return p << 1;
        }

        private int right(int p) {
            return (p << 1) + 1;
        }

    }


}
