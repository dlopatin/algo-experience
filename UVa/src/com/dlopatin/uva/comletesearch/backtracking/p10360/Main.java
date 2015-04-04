package com.dlopatin.uva.comletesearch.backtracking.p10360;

import java.io.IOException;
import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=15&page=show_problem&problem=1301
*/
public class Main {

	private final int ROWS = 1025;

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- != 0) {
				int[][] field = new int[ROWS][ROWS];
				int d = scanner.nextInt();
				int rats = scanner.nextInt();
				while (rats-- > 0) {
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					int population = scanner.nextInt();

					int i0 = (x - d < 0) ? 0 : x - d;
					int in = (x + d < ROWS) ? x + d : ROWS - 1;

					int j0 = (y - d < 0) ? 0 : y - d;
					int jn = (y + d < ROWS) ? y + d : ROWS - 1;

					for (int i = i0; i <= in; i++) {
						for (int j = j0; j <= jn; j++) {
							field[i][j] += population;
						}
					}
				}
				int max = 0;
				int optX = 0;
				int optY = 0;
				for (int i = 0; i < ROWS; i++) {
					for (int j = 0; j < ROWS; j++) {
						if (max < field[i][j]) {
							optX = i;
							optY = j;
							max = field[i][j];
						}
					}
				}
				System.out.printf("%d %d %d\n", optX, optY, max);

			}
		}

	}

}
