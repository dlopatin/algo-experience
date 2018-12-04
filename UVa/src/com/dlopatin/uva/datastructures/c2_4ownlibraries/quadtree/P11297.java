package com.dlopatin.uva.datastructures.c2_4ownlibraries.quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2272
 * Census
 * Quadtree solution
 */
public class P11297 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = parseInt(reader.readLine());
            PointQuadtree quadtree = new PointQuadtree(new Rectangle(
                    new Point(1, 1),
                    new Point(n, n)));
            for (int y = 1; y <= n; y++) {
                StringTokenizer data = new StringTokenizer(reader.readLine());
                for (int x = 1; x <= n; x++) {
                    quadtree.insert(new Point(x, y, parseInt(data.nextToken())));
                }
            }
            StringBuilder result = new StringBuilder();
            int q = parseInt(reader.readLine());
            while (q-- > 0) {
                StringTokenizer command = new StringTokenizer(reader.readLine());
                if ("q".equals(command.nextToken())) {
                    int y1 = parseInt(command.nextToken());
                    int x1 = parseInt(command.nextToken());
                    int y2 = parseInt(command.nextToken());
                    int x2 = parseInt(command.nextToken());
                    result.append(
                            quadtree.query(new Rectangle(
                                    x1,
                                    y1,
                                    x2,
                                    y2)))
                            .append("\n");
                } else {
                    int y = parseInt(command.nextToken());
                    int x = parseInt(command.nextToken());
                    quadtree.insert(new Point(
                            x,
                            y,
                            parseInt(command.nextToken())));
                }
            }
            System.out.print(result);
        }
    }

    private static class Point {
        private final int x;
        private final int y;
        private int value;

        public Point(Point other) {
            x = other.x;
            y = other.y;
            value = other.value;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("x=%02d, y=%02d, value=%05d", x, y, value);
        }
    }

    private static class Rectangle {
        private final Point topLeft;
        private final Point botRight;

        public Rectangle(Point topLeft, Point botRight) {
            this.topLeft = topLeft;
            this.botRight = botRight;
        }

        public Rectangle(int x1, int y1, int x2, int y2) {
            topLeft = new Point(x1, y1);
            botRight = new Point(x2, y2);
        }

        public boolean contains(Point point) {
            return point.x >= topLeft.x &&
                    point.x <= botRight.x &&
                    point.y >= topLeft.y &&
                    point.y <= botRight.y;
        }

        public boolean intersects(Rectangle range) {
            return !(topLeft.x > range.botRight.x ||
                    botRight.x < range.topLeft.x ||
                    topLeft.y > range.botRight.y ||
                    botRight.y < range.topLeft.y);
        }

        public boolean includes(Rectangle other) {
            return topLeft.x <= other.topLeft.x &&
                    botRight.x >= other.botRight.x &&
                    topLeft.y <= other.topLeft.y &&
                    botRight.y >= other.botRight.y;
        }

        public boolean isDivisible() {
            return Math.abs(topLeft.x - botRight.x) >= 1 || Math.abs(topLeft.y - botRight.y) >= 1;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d] [%d, %d]", topLeft.x, topLeft.y, botRight.x, botRight.y);
        }
    }

    private static class PointQuadtree {
        private final Rectangle boundary;
        private Point data;

        private PointQuadtree nw;
        private PointQuadtree ne;
        private PointQuadtree sw;
        private PointQuadtree se;

        private int min = Integer.MAX_VALUE;
        private int max = Integer.MIN_VALUE;

        public PointQuadtree(Rectangle boundary) {
            this.boundary = boundary;
        }

        public boolean insert(Point point) {
            if (data != null) {
                // upsert
                if (data.x == point.x && data.y == point.y) {
                    setValue(point);
                    return true;
                }
                return false;
            }
            if (!boundary.contains(point)) {
                return false;
            }

            if (boundary.isDivisible()) {
                subdivide();

                boolean inserted = nw.insert(point) || ne.insert(point) || sw.insert(point) || se.insert(point);
                if (inserted) {
                    max = IntStream.of(nw.max, ne.max, sw.max, se.max).max().getAsInt();
                    min = IntStream.of(nw.min, ne.min, sw.min, se.min).min().getAsInt();
                }
                return inserted;
            } else {
                setValue(point);
                return true;
            }
        }

        public MinMax query(Rectangle range) {
            if (!range.intersects(boundary)) {
                return MinMax.nullSafe();
            }
            if (range.includes(boundary)) {
                return new MinMax(min, max);
            }
            if (nw == null) {
                return MinMax.nullSafe();
            }
            return Stream.of(nw.query(range), ne.query(range), sw.query(range), se.query(range))
                    .reduce(MinMax::combine)
                    .get();
        }


        private void subdivide() {
            if (nw != null) {
                // already divided
                return;
            }
            int xTop = boundary.topLeft.x;
            int xBottom = boundary.botRight.x;
            int xMiddle = (xTop + xBottom) / 2;
            int yTop = boundary.topLeft.y;
            int yBottom = boundary.botRight.y;
            int yMiddle = (yTop + yBottom) / 2;
            nw = new PointQuadtree(new Rectangle(boundary.topLeft, new Point(xMiddle, yMiddle)));

            ne = new PointQuadtree(new Rectangle(
                    new Point(xMiddle + 1, yTop),
                    new Point(xBottom, yMiddle)));

            sw = new PointQuadtree(new Rectangle(
                    new Point(xTop, yMiddle + 1),
                    new Point(xMiddle, yBottom)));

            se = new PointQuadtree(new Rectangle(
                    new Point(xMiddle + 1, yMiddle + 1),
                    new Point(xBottom, yBottom)));

        }

        private void setValue(Point value) {
            data = value;
            min = value.value;
            max = value.value;
//            System.out.printf("set: %s, boundary=%s\n", value, boundary);
        }

        private static class MinMax {
            private static final MinMax NULL_SAFE = new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);

            private final int min;
            private final int max;

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

}
