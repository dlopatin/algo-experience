package com.dlopatin.uva.comletesearch.backtracking.easy;

import java.util.Arrays;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=103
 */
public class P167 {

    private static final int ROWS = 8;
    private final int[] rows = new int[ROWS];
    private final int[][] chessboard = new int[ROWS][ROWS];
    private int result = 0;
    private final StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        new P167().doJob();
    }

    private void doJob() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            while (n-- != 0) {
                Arrays.fill(rows, 0);
                result = 0;
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < ROWS; j++) {
                        chessboard[i][j] = scanner.nextInt();
                    }
                }
                backtrack(0);
                builder.append(String.format("%5d\n", result));
            }
            System.out.print(builder.toString());
        }

    }

    private void backtrack(int col) {
        for (int rowToPlace = 0; rowToPlace < ROWS; rowToPlace++) {
            if (place(col, rowToPlace)) {
                rows[col] = rowToPlace;
                if (col == 7) {
                    // 1 4 2 5 8 6 1 3 7
                    int sum = 0;
                    for (int i = 0; i < rows.length; i++) {
                        sum += chessboard[rows[i]][i];
                    }
                    result = Math.max(sum, result);
                } else if (col != 7) {
                    backtrack(col + 1);
                }
            }
        }
    }

    private boolean place(int col, int rowToPlace) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            if (rows[prevCol] == rowToPlace || Math.abs(rows[prevCol] - rowToPlace) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

}
