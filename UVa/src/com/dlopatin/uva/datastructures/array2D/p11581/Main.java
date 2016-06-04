package com.dlopatin.uva.datastructures.array2D.p11581;

import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=624&page=show_problem&problem=2628
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = scanner.nextInt();
			while (n-- > 0) {
				int[][] source = new int[5][5];
				int[][] work = new int[5][5];
				for (int i = 1; i < 4; i++) {
					char[] line = scanner.next().toCharArray();
					for (int j = 1; j < 4; j++) {
						source[i][j] = line[j - 1] - '0';
						work[i][j] = line[j - 1] - '0';
					}
				}
				int counter = 0;
				while (true) {
					int[][] newgrid = new int[5][5];
					for (int i = 1; i < 4; i++) {
						for (int j = 1; j < 4; j++) {
							newgrid[i][j] = (work[i + 1][j] + work[i - 1][j] + work[i][j - 1] + work[i][j + 1]) % 2;
						}

					}
					if (isEqual(newgrid, source)) {
						result.append("-1");
						counter = 0;
						break;
					}
					if (isEqual(newgrid, work)) {
						result.append(counter - 1);
						counter = 0;
						break;
					}
					counter++;
					work = newgrid;
				}
				result.append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}

	private boolean isEqual(int[][] first, int[][] second) {
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (first[i][j] != second[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
