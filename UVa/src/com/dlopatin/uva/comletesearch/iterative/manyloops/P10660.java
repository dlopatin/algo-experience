package com.dlopatin.uva.comletesearch.iterative.manyloops;

import java.util.Arrays;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=18&page=show_problem&problem=1601
 */
public class P10660 {

    private static final int CELLS = 25;

    public static void main(String[] args) throws NumberFormatException {
        new P10660().doJob();
    }

    private void doJob() throws NumberFormatException {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t-- != 0) {
                int n = scanner.nextInt();
                int[][] area = new int[5][5];
                for (int i = 0; i < n; i++) {
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int population = scanner.nextInt();
                    area[a][b] = population;
                }
                int[] offices = new int[5];
                long minDist = Long.MAX_VALUE;
                for (int a = 0; a < CELLS; a++) {
                    for (int b = a + 1; b < CELLS; b++) {
                        for (int c = b + 1; c < CELLS; c++) {
                            for (int d = c + 1; d < CELLS; d++) {
                                for (int e = d + 1; e < CELLS; e++) {

                                    long currentDist = 0;
                                    for (int i = 0; i < 5; i++) {
                                        for (int j = 0; j < 5; j++) {
                                            int dist = Integer.MAX_VALUE;
                                            dist = Math.min(dist, dist(a, i, j));
                                            dist = Math.min(dist, dist(b, i, j));
                                            dist = Math.min(dist, dist(c, i, j));
                                            dist = Math.min(dist, dist(d, i, j));
                                            dist = Math.min(dist, dist(e, i, j));
                                            currentDist += dist * area[i][j];
                                        }
                                    }

                                    if (currentDist < minDist) {
                                        minDist = currentDist;
                                        offices[0] = a;
                                        offices[1] = b;
                                        offices[2] = c;
                                        offices[3] = d;
                                        offices[4] = e;
                                    }

                                }
                            }
                        }
                    }
                }
                Arrays.sort(offices);
                StringBuilder builder = new StringBuilder();
                for (int office : offices) {
                    builder.append(office).append(" ");
                }
                System.out.println(builder.toString().trim());
            }
        }

    }

    private int dist(int office, int i, int j) {
        int iOffice = office / 5;
        int jOffice = office % 5;
        return Math.abs(i - iOffice) + Math.abs(j - jOffice);
    }

}
