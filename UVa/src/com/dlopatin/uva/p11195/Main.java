package com.dlopatin.uva.p11195;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=23&page=show_problem&problem=2136
*/
public class Main {

	private int[] rows;
	private int usedRows;
	private int[][] chessboard;
	private int result = 0;
	private final StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = 0;
			int counter = 0;
			while ((n = scanner.nextInt()) != 0) {
				result = 0;
				rows = new int[n];
				chessboard = new int[n][n];
				for (int i = 0; i < n; i++) {
					char[] line = scanner.next().toCharArray();
					for (int j = 0; j < n; j++) {
						chessboard[i][j] = line[j] == '.' ? 1 : 0;
					}
				}
				usedRows = (1 << n) - 1; // set all bits = 1
				long startTime = System.currentTimeMillis();
				backtrack(0, n);
				long endTime = System.currentTimeMillis();
				System.out.println((endTime - startTime) / 1000.0);
				builder.append(String.format("Case %d: %d\n", ++counter, result));
			}
			System.out.println(builder.toString());
		}

	}

	private void backtrack(int col, int n) {
		for (int rowToPlace = 0; rowToPlace < n; rowToPlace++) {
			if (place(col, rowToPlace)) {
				// find bit from right to left with `rowToPlace` position
				int usedRowMask = 1 << rowToPlace;
				// invert mask and use 'and' operation to set `rowToPlace` bit
				// to 0
				usedRows &= ~usedRowMask;

				rows[col] = rowToPlace;
				if (col == n - 1) {
					result++;
				} else if (col != n - 1) {
					backtrack(col + 1, n);
				}
				usedRows |= usedRowMask; // set back `rowToPlace` bit to 1

			}
		}
	}

	private boolean place(int col, int rowToPlace) {
		if (chessboard[rowToPlace][col] == 0) {
			return false;
		}
		if ((usedRows & (1 << rowToPlace)) == 0) {
			return false;
		}
		for (int prevCol = 0; prevCol < col; prevCol++) {
			if (rows[prevCol] == rowToPlace || Math.abs(rows[prevCol] - rowToPlace) == Math.abs(prevCol - col)) {
				return false;
			}
		}
		return true;
	}

}
