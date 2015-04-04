package com.dlopatin.uva.comletesearch.backtracking.p11085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=22&page=show_problem&problem=2026
*/
public class Main {

	private static final int ROWS = 8;
	private final int[] rows = new int[ROWS];
	private final int[] sourceRows = new int[ROWS];
	private int min = Integer.MAX_VALUE;
	private final StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			int counter = 0;
			String line;
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				StringTokenizer data = new StringTokenizer(line);
				Arrays.fill(rows, 0);
				min = Integer.MAX_VALUE;
				for (int i = 0; i < ROWS; i++) {
					sourceRows[i] = Integer.parseInt(data.nextToken()) - 1;
				}
				backtrack(0);
				builder.append(String.format("Case %d: %d\n", ++counter, min));
			}
			System.out.println(builder.toString().trim());
		}

	}

	private void backtrack(int col) {
		for (int rowToPlace = 0; rowToPlace < ROWS; rowToPlace++) {
			if (place(col, rowToPlace)) {
				rows[col] = rowToPlace;
				if (col == ROWS - 1) {
					int sumOfSteps = 0;
					for (int column = 0; column < ROWS; column++) {
						sumOfSteps += (rows[column] == sourceRows[column]) ? 0 : 1;
					}
					min = Math.min(sumOfSteps, min);
				} else if (col != ROWS - 1) {
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
