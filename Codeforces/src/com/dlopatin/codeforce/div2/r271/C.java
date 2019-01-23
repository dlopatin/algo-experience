package com.dlopatin.codeforce.div2.r271;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/474/problem/C
 */
public class C {

    public static void main(String[] args) throws IOException, ParseException {
        new C().doJob();
    }

    private void doJob() throws ParseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < n; i++) {
                Mole[][] regiment = new Mole[4][4];
                for (int j = 0; j < 4; j++) {
                    Mole mole = new Mole(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 0);
                    regiment[0][j] = mole;
                    for (int k = 1; k < 4; k++) {
                        regiment[k][j] = rotate(regiment[k - 1][j]);
                    }
                }
                res.append(findMinRotation(regiment)).append(System.lineSeparator());
            }
            System.out.println(res);

        }
    }

    private int findMinRotation(Mole[][] regiment) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        Mole a = regiment[i][0];
                        Mole b = regiment[j][1];
                        Mole c = regiment[k][2];
                        Mole d = regiment[l][3];
                        if (isSquare(a, b, c, d)) {
                            int rotation = a.weight + b.weight + c.weight + d.weight;
                            if (min > rotation) {
                                min = rotation;
                                if (min == 0) {
                                    return min;
                                }
                            }
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isSquare(Mole... points) {
        int[] sides = new int[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = distance(points[0], points[i + 1]);
            if (sides[i] == 0) {
                return false;
            }
        }

        int equalSide1 = -1;
        int unequalSide = -1;

        if (sides[0] == sides[1]) {
            if (sides[0] != sides[2]) {
                equalSide1 = 0;
                unequalSide = 2;
            }
        } else if (sides[1] == sides[2]) {
            if (sides[1] != sides[0]) {
                equalSide1 = 1;
                unequalSide = 0;
            }
        } else if (sides[0] == sides[2]) {
            if (sides[0] != sides[1]) {
                equalSide1 = 0;
                unequalSide = 1;
            }
        }
        if (equalSide1 != -1) {
            int opposing = 0;
            switch (unequalSide) {
                case 0:
                    opposing = distance(points[2], points[3]);
                    break;
                case 1:
                    opposing = distance(points[1], points[3]);
                    break;
                case 2:
                    opposing = distance(points[1], points[2]);
                    break;
                default:
                    break;
            }

            if (opposing == sides[unequalSide]) {

                int diagonal = opposing;
                int adjacent = sides[equalSide1];
                for (int a = 0; a < 4; a++) {
                    int diagonalCount = 0;
                    int adjacentCount = 0;
                    for (int b = 0; b < 4; b++) {
                        if (a != b) {
                            int dist = distance(points[a], points[b]);
                            if (dist == diagonal) {
                                diagonalCount++;
                            } else if (dist == adjacent) {
                                adjacentCount++;
                            }
                        }
                    }
                    if (!(diagonalCount == 1 && adjacentCount == 2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int distance(Mole point, Mole point2) {
        return (int) (Math.pow(point.x - point2.x, 2) + (Math.pow(point.y - point2.y, 2)));
    }

    private Mole rotate(Mole mole) {
        int x = mole.getB() - mole.getY() + mole.getA();
        int y = mole.getB() + mole.getX() - mole.getA();
        return new Mole(x, y, mole.getA(), mole.getB(), mole.getWeight() + 1);
    }

    private static class Mole {
        private final int x;
        private final int y;
        private final int a;
        private final int b;
        private final int weight;

        public Mole(int x, int y, int a, int b, int weight) {
            super();
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Mole [x=" + x + ", y=" + y + ", a=" + a + ", b=" + b + ", weight=" + weight + "]";
        }

    }

}
