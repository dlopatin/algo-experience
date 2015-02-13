package com.dlopatin.uva.p11195;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=23&page=show_problem&problem=2136
*/
public class Main {

	private int[] rows;
	private int usedRows;
	private int ld, rd;
	private int[][] chessboard;
	private int result = 0;
	private final int[] id = new int[1 << 14];
	private final StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			// init map to convert mask with one flag to int value
			for (int i = 0; i < 14; i++) {
				id[1 << i] = i;
			}
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
				ld = ~0;
				rd = ~0;
//				long startTime = System.currentTimeMillis();
				backtrack(0, n);
//				long endTime = System.currentTimeMillis();
//				System.out.println((endTime - startTime) / 1000.0);
				builder.append(String.format("Case %d: %d\n", ++counter, result));
			}
			System.out.print(builder.toString());
		}

	}

	private void backtrack(int col, int n) {
		int rowMask = usedRows & (-usedRows);
		int rowToPlace = id[rowMask];
		while (rowToPlace < n && rowMask > 0) {

			if (place(col, rowToPlace, n)) {
				// find bit from right to left with `rowToPlace` position
				int ldMask = lDMask(n, col, rowToPlace);
				int rdMask = rDMask(n, col, rowToPlace);
				// invert mask and use 'and' operation to set `rowToPlace` bit to 0 (disables row)
				usedRows &= ~rowMask;
				ld &= ~ldMask;
				rd &= ~rdMask;

				rows[col] = rowToPlace;
				if (col == n - 1) {
					result++;
				} else if (col != n - 1) {
					backtrack(col + 1, n);
				}
				usedRows |= rowMask; // set back `rowToPlace` bit to 1 (enables row)
				ld |= ldMask;
				rd |= rdMask;
			}
			rowMask = usedRows & (~0 << (rowToPlace + 1));
			rowToPlace = id[rowMask & (-rowMask)];
		}
	}

	private boolean place(int col, int rowToPlace, int n) {
		if (chessboard[rowToPlace][col] == 0) {
			return false;
		}
		if ((ld & lDMask(n, col, rowToPlace)) == 0 || (rd & rDMask(n, col, rowToPlace)) == 0) {
			return false;
		}
		return true;
	}

	// left diagonal mask based on function: row - col = const
	private int lDMask(int n, int col, int row) {
		return 1 << (2 * n - 1 - row + col);
	}

	// right diagonal mask based on function: row + col = const
	private int rDMask(int n, int col, int row) {
		return 1 << (2 * n - 1 - row - col);
	}
}
