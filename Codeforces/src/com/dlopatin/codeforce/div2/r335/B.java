package com.dlopatin.codeforce.div2.r335;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/606/problem/B
 */
public class B {

    public static void main(String[] args) {
        new B().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int i = scanner.nextInt() - 1;
            int j = scanner.nextInt() - 1;

            char[] commands = scanner.next().toCharArray();
            int[][] field = new int[n][m];
            field[i][j] = 1;
            StringBuilder res = new StringBuilder();
            res.append(1).append(" ");
            int idx = 0;
            int count = 1;
            for (char command : commands) {
                int kRes = 0;
                switch (command) {
                    case 'L':
                        if (canDo(i, j - 1, n, m)) {
                            j--;
                            if (field[i][j] > 0) {
                                kRes = 0;
                            } else {
                                kRes = 1;
                                field[i][j]++;
                            }
                        } else {
                            kRes = 0;
                        }
                        break;
                    case 'R':
                        if (canDo(i, j + 1, n, m)) {
                            j++;
                            if (field[i][j] > 0) {
                                kRes = 0;
                            } else {
                                kRes = 1;
                                field[i][j]++;
                            }
                        } else {
                            kRes = 0;
                        }
                        break;
                    case 'U':
                        if (canDo(i - 1, j, n, m)) {
                            i--;
                            if (field[i][j] > 0) {
                                kRes = 0;
                            } else {
                                kRes = 1;
                                field[i][j]++;
                            }
                        } else {
                            kRes = 0;
                        }
                        break;
                    case 'D':
                        if (canDo(i + 1, j, n, m)) {
                            i++;
                            if (field[i][j] > 0) {
                                kRes = 0;
                            } else {
                                kRes = 1;
                                field[i][j]++;
                            }
                        } else {
                            kRes = 0;
                        }
                        break;
                    default:
                        break;
                }
                if (idx != commands.length - 1) {
                    count += kRes;
                    res.append(kRes).append(" ");
                }
                idx++;
            }
            res.append(n * m - count);
            System.out.println(res.toString().trim());
        }
    }

    private boolean canDo(int i, int j, int n, int m) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }
}