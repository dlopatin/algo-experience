package com.dlopatin.uva.datastructures.c2_4ownlibraries.segmenttree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2272
 * Census
 * 2D segment tree
 * http://e-maxx.ru/algo/segment_tree#26
 */
public class P11297 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            int[][] data = new int[n][n];
            for (int x = 0; x < n; x++) {
                StringTokenizer inputData = new StringTokenizer(reader.readLine());
                for (int y = 0; y < n; y++) {
                    data[x][y] = parseInt(inputData.nextToken());
                }
            }
            SegmentTree2D tree2D = new SegmentTree2D(data);
            StringBuilder result = new StringBuilder();
            int q = parseInt(reader.readLine());
            while (q-- > 0) {
                StringTokenizer command = new StringTokenizer(reader.readLine());
                if ("q".equals(command.nextToken())) {
                    int x1 = parseInt(command.nextToken()) - 1;
                    int y1 = parseInt(command.nextToken()) - 1;
                    int x2 = parseInt(command.nextToken()) - 1;
                    int y2 = parseInt(command.nextToken()) - 1;
                    result.append(tree2D.query(x1, y1, x2, y2)).append("\n");
                } else {
                    int x = parseInt(command.nextToken()) - 1;
                    int y = parseInt(command.nextToken()) - 1;
                    tree2D.update(x, y, parseInt(command.nextToken()));
                }
            }
            System.out.print(result);
        }
    }

    private static class SegmentTree2D {
        private final MinMax[][] st;
        private final int[][] data;

        public SegmentTree2D(int[][] data) {
            st = new MinMax[4 * data.length][4 * data.length];
            this.data = data;
            buildX(1, 0, data.length - 1);
        }

        private void buildX(int px, int lx, int rx) {
            if (lx != rx) {
                int midX = lx + (rx - lx) / 2;
                buildX(left(px), lx, midX);
                buildX(right(px), midX + 1, rx);
            }
            buildY(px, lx, rx, 1, 0, data.length - 1);
        }

        private void buildY(int px, int lx, int rx, int py, int ly, int ry) {
            if (ly == ry) {
                if (lx == rx) {
                    st[px][py] = new MinMax(data[lx][ly]);
                } else {
                    st[px][py] = st[left(px)][py].combine(st[right(px)][py]);
                }
            } else {
                int midY = ly + (ry - ly) / 2;
                buildY(px, lx, rx, left(py), ly, midY);
                buildY(px, lx, rx, right(py), midY + 1, ry);
                st[px][py] = st[px][left(py)].combine(st[px][right(py)]);
            }
        }

        public MinMax query(int ix, int iy, int jx, int jy) {
            return queryX(1, 0, data.length - 1, ix, jx, iy, jy);
        }

        private MinMax queryX(int px, int lx, int rx, int ix, int jx, int iy, int jy) {
            if (lx > jx || rx < ix) {
                return MinMax.NULL_SAFE;
            }
            if (lx >= ix && rx <= jx) {
                return queryY(px, 1, 0, data.length - 1, iy, jy);
            }
            int midX = lx + (rx - lx) / 2;
            MinMax leftX = queryX(left(px), lx, midX, ix, jx, iy, jy);
            MinMax leftY = queryX(right(px), midX + 1, rx, ix, jx, iy, jy);
            return leftX.combine(leftY);
        }

        private MinMax queryY(int px, int py, int ly, int ry, int iy, int jy) {
            if (ly > jy || ry < iy) {
                return MinMax.NULL_SAFE;
            }
            if (ly >= iy && ry <= jy) {
                return st[px][py];
            }
            int midY = ly + (ry - ly) / 2;
            MinMax leftY = queryY(px, left(py), ly, midY, iy, jy);
            MinMax rightY = queryY(px, right(py), midY + 1, ry, iy, jy);
            return leftY.combine(rightY);
        }

        public void update(int i, int j, int val) {
            updateX(1, 0, data.length - 1, i, j, val);
        }

        private void updateX(int px, int lx, int rx, int i, int j, int val) {
            if (lx != rx) {
                int midX = lx + (rx - lx) / 2;
                if (i <= midX) {
                    updateX(left(px), lx, midX, i, j, val);
                } else {
                    updateX(right(px), midX + 1, rx, i, j, val);
                }
            }
            updateY(px, lx, rx, 1, 0, data.length - 1, i, j, val);
        }

        private void updateY(int px, int lx, int rx, int py, int ly, int ry, int i, int j, int val) {
            if (ly == ry) {
                if (rx == lx) {
                    st[px][py] = new MinMax(val);
                } else {
                    st[px][py] = st[left(px)][py].combine(st[right(px)][py]);
                }
            } else {
                int midY = ly + (ry - ly) / 2;
                if (j <= midY) {
                    updateY(px, lx, rx, left(py), ly, midY, i, j, val);
                } else {
                    updateY(px, lx, rx, right(py), midY + 1, ry, i, j, val);
                }
                st[px][py] = st[px][left(py)].combine(st[px][right(py)]);
            }
        }


        private int left(int p) {
            return p << 1;
        }

        private int right(int p) {
            return (p << 1) + 1;
        }
    }

    private static class MinMax {
        private static final MinMax NULL_SAFE = new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);

        private final int min;
        private final int max;

        public MinMax(int val) {
            min = val;
            max = val;
        }

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public MinMax combine(MinMax other) {
            return new MinMax(Math.min(min, other.min), Math.max(max, other.max));
        }

        public static MinMax nullSafe() {
            return NULL_SAFE;
        }

        @Override
        public String toString() {
            return String.format("%d %d", max, min);
        }
    }

}
