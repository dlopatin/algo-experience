package com.dlopatin.uva.comletesearch.backtracking.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=22&page=show_problem&problem=2026
 * Back to the 8-Queens
 */
public class P11085 {

    private static final int ROWS = 8;
    private final int[] rows = new int[ROWS];
    private final int[][] solutions = new int[92][8];
    private int solIdx = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        new P11085().doJob();
    }

    private void doJob() throws NumberFormatException, IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // pre-calculate
            backtrack(0);

            int caseId = 0;
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                StringTokenizer data = new StringTokenizer(line);
                Arrays.fill(rows, 0);
                int[] sourceRows = new int[ROWS];
                for (int i = 0; i < ROWS; i++) {
                    sourceRows[i] = Integer.parseInt(data.nextToken()) - 1;
                }

                int min = Integer.MAX_VALUE;
                for (int[] solution : solutions) {
                    int count = 0;
                    for (int i = 0; i < solution.length; i++) {
                        if (solution[i] != sourceRows[i]) {
                            count++;
                        }
                    }
                    min = Math.min(min, count);
                }
                builder.append(String.format("Case %d: %d\n", ++caseId, min));
            }
            System.out.print(builder);
        }

    }

    private void backtrack(int col) {
        for (int rowToPlace = 0; rowToPlace < ROWS; rowToPlace++) {
            if (place(col, rowToPlace)) {
                rows[col] = rowToPlace;
                if (col == ROWS - 1) {
                    System.arraycopy(rows, 0, solutions[solIdx], 0, ROWS);
                    solIdx++;
                } else {
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
