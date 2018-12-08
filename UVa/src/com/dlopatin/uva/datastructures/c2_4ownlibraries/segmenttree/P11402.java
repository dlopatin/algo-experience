package com.dlopatin.uva.datastructures.c2_4ownlibraries.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=26&page=show_problem&problem=2397<p>
 * Segment tree<p>
 * Ahoy, Pirates!
 *
 * @see <a href="https://www.geeksforgeeks.org/lazy-propagation-in-segment-tree/">LazySegmentTree</a>
 * @see <a href="https://www.redgreencode.com/solving-uva-11402-with-segment-trees/">
 * SOLVING UVA 11402 WITH SEGMENT TREES</a>
 */
public class P11402 {

    private static final BiFunction<Integer, Integer, Integer> ONES = (stored, length) -> length;
    private static final BiFunction<Integer, Integer, Integer> ZEROS = (stored, length) -> 0;
    private static final BiFunction<Integer, Integer, Integer> INVERSE = (stored, length) -> length - stored;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int cases = parseInt(reader.readLine());
            for (int idx = 1; idx <= cases; idx++) {
                result.append("Case ").append(idx).append(":\n");
                int m = parseInt(reader.readLine());
                StringBuilder data = new StringBuilder();
                while (m-- > 0) {
                    int nTimes = parseInt(reader.readLine());
                    String s = reader.readLine();
                    while (nTimes-- > 0) {
                        data.append(s);
                    }
                }
                LazySegmentTree lazySegmentTree = new LazySegmentTree(data);
                int q = parseInt(reader.readLine());
                int searchIdx = 1;
                while (q-- > 0) {
                    StringTokenizer queryData = new StringTokenizer(reader.readLine());
                    char action = queryData.nextToken().charAt(0);
                    int i = parseInt(queryData.nextToken());
                    int j = parseInt(queryData.nextToken());
                    switch (action) {
                        case 'F': // fill with 1
                            lazySegmentTree.updateRange(i, j, ONES);
                            break;
                        case 'E': // erase with 0
                            lazySegmentTree.updateRange(i, j, ZEROS);
                            break;
                        case 'I': // inverse
                            lazySegmentTree.updateRange(i, j, INVERSE);
                            break;
                        default: // search
                            result.append("Q").append(searchIdx++).append(": ")
                                    .append(lazySegmentTree.query(i, j))
                                    .append("\n");
                            break;
                    }
                }
            }
            System.out.print(result);
        }
    }

    private static class LazySegmentTree {
        private final int[] st;
        private final BiFunction<Integer, Integer, Integer>[] pending;
        private final CharSequence data;

        public LazySegmentTree(CharSequence data) {
            this.data = data;
            st = new int[4 * data.length()];
            pending = new BiFunction[st.length];
            build(1, 0, data.length() - 1);
        }

        private void build(int p, int l, int r) {
            if (l == r) {
                st[p] = data.charAt(l) - '0';
            } else {
                int mid = l + (r - l) / 2;
                build(left(p), l, mid);
                build(right(p), mid + 1, r);
                st[p] = st[left(p)] + st[right(p)];
            }
        }

        public int query(int i, int j) {
            return query(1, 0, data.length() - 1, i, j);
        }

        private int query(int p, int l, int r, int i, int j) {
            if (l > j || r < i || l > r) {
                return 0;
            }
            performPendingOperation(p, l, r);
            if (l >= i && r <= j) {
                return st[p];
            }
            int mid = l + (r - l) / 2;
            return query(left(p), l, mid, i, j) + query(right(p), mid + 1, r, i, j);
        }

        public void updateRange(int i, int j, BiFunction<Integer, Integer, Integer> function) {
            updateRange(1, 0, data.length() - 1, i, j, function);
        }

        private void updateRange(int p, int l, int r, int i, int j, BiFunction<Integer, Integer, Integer> function) {
            performPendingOperation(p, l, r);
            // out of range
            if (i > r || j < l || l > r) {
                return;
            }

            // current segment is fully in range
            if (l >= i && r <= j) {
                // index range is inclusive of data array
                int lengthOfData = r - l + 1;
                st[p] = function.apply(st[p], lengthOfData);
                if (l != r) {
                    addPendingFunction(left(p), function);
                    addPendingFunction(right(p), function);
                }
                return;
            }

            // if not completely in range, but overlaps, recur for children.
            int mid = l + (r - l) / 2;
            updateRange(left(p), l, mid, i, j, function);
            updateRange(right(p), mid + 1, r, i, j, function);

            st[p] = st[left(p)] + st[right(p)];
        }

        private void performPendingOperation(int p, int l, int r) {
            if (pending[p] != null) {
                int lengthOfData = r - l + 1;
                st[p] = pending[p].apply(st[p], lengthOfData);
                if (l != r) {
                    addPendingFunction(left(p), pending[p]);
                    addPendingFunction(right(p), pending[p]);
                }
                pending[p] = null;
            }
        }

        private void addPendingFunction(int p, BiFunction<Integer, Integer, Integer> function) {
            if (function == INVERSE) {
                if (pending[p] == null) {
                    pending[p] = function;
                } else if (pending[p] == ONES) {
                    pending[p] = ZEROS;
                } else if (pending[p] == ZEROS) {
                    pending[p] = ONES;
                } else {
                    // inverse to inverse gives nothing
                    pending[p] = null;
                }
            } else {
                pending[p] = function;
            }
        }

        private int left(int p) {
            return p << 1;
        }

        private int right(int p) {
            return (p << 1) + 1;
        }

    }


}
