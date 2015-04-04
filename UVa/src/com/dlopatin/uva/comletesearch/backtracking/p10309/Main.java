package com.dlopatin.uva.comletesearch.backtracking.p10309;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=15&page=show_problem&problem=1250
*/
public class Main {

	private static final int MAX_SIZE = 10;

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			String name = "";
			char[][] lines = new char[MAX_SIZE][];
			while (!"end".equals(name = scanner.next())) {
				for (int i = 0; i < MAX_SIZE; i++) {
					lines[i] = scanner.next().toCharArray();
				}
				int min = Integer.MAX_VALUE;
				for (int mask = 0; mask < (1 << MAX_SIZE); mask++) {

					char[][] workArray = new char[MAX_SIZE][];
					for (int k = 0; k < MAX_SIZE; k++) {
						workArray[k] = Arrays.copyOf(lines[k], MAX_SIZE);
					}

					int counter = iterate(mask, workArray);
					if (isAllGood(workArray) && counter <= 100) {
						min = Math.min(min, counter);
					}
				}
				System.out.printf("%s %d\n", name, (min > 100) ? -1 : min);
			}

		}

	}

	private int iterate(int mask, char[][] workArray) {
		int counter = 0;
		for (int j = 0; j < MAX_SIZE; j++) {
			if ((mask & (1 << j)) != 0) {
				switchLight(workArray, 0, j);
				counter++;
			}
		}
		for (int i = 0; i < MAX_SIZE - 1; i++) {
			for (int l = 0; l < MAX_SIZE; l++) {
				if (workArray[i][l] == 'O') {
					switchLight(workArray, i + 1, l);
					counter++;
					if (counter > 100) {
						return counter;
					}
				}
			}
		}
		return counter;
	}

	private void switchLight(char[][] array, int i, int j) {
		array[i][j] = opposite(array[i][j]);

		int is[] = { 0, -1, 0, 1 };
		int js[] = { -1, 0, 1, 0 };

		for (int l = 0; l < is.length; l++) {
			int nexti = i + is[l];
			int nextj = j + js[l];

			if (nexti >= 0 && nexti < MAX_SIZE && nextj >= 0 && nextj < MAX_SIZE) {
				array[nexti][nextj] = opposite(array[nexti][nextj]);
			}
		}
	}

	private char opposite(char ch) {
		if ('O' == ch) {
			return '#';
		} else {
			return 'O';
		}
	}

	private boolean isAllGood(char array[][]) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (array[array.length - 1][i] == 'O') {
				return false;
			}
		}
		return true;
	}

}
