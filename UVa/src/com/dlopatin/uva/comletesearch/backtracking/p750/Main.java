package com.dlopatin.uva.comletesearch.backtracking.p750;

import java.util.Arrays;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=363&page=show_problem&problem=691
*/
public class Main {

	private static final int ROWS = 8;
	private int a;
	private int b;
	private int lineCnt = 0;
	private final int[] rows = new int[ROWS];
	private final StringBuilder result = new StringBuilder();

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- != 0) {
				a = scanner.nextInt() - 1;
				b = scanner.nextInt() - 1;
				Arrays.fill(rows, 0);
				lineCnt = 0;
				result.append("SOLN       COLUMN\n").append(" #      1 2 3 4 5 6 7 8\n\n");
				backtrack(0);
				result.append(System.lineSeparator());
			}
			System.out.println(result.toString().trim());
		}

	}

	private void backtrack(int col) {
		for (int rowToPlace = 0; rowToPlace < ROWS; rowToPlace++) {
			if (place(col, rowToPlace)) {
				rows[col] = rowToPlace;
				if (col == 7 && rows[b] == a) {
					// 1 4 2 5 8 6 1 3 7
					result.append(String.format("%2d", ++lineCnt)).append("     ");
					for (int i = 0; i < rows.length; i++) {
						result.append(" ").append(rows[i] + 1);
					}
					result.append(System.lineSeparator());
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
