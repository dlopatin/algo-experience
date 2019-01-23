package com.dlopatin.codeforce.div2.r340;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/617/problem/С
 */
public class C {

    public static void main(String[] args) {
        new C().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            Point r1 = new Point(scanner.nextInt(), scanner.nextInt());
            Point r2 = new Point(scanner.nextInt(), scanner.nextInt());
            while (n-- > 0) {

            }
        }
    }

    private long distance(Point point, Point point2) {
        return (int) (Math.pow(point.x - point2.x, 2) + (Math.pow(point.y - point2.y, 2)));
    }

    private class Point {
        private final int x;
        private final int y;
        private long d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setD(long d) {
            this.d = d;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }

    }
}