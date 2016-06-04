package com.dlopatin.uva.datastructures.array.p12356;

import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=623&page=show_problem&problem=979
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {
				int b = scanner.nextInt();
				int[][] line = new int[n][2];
				for (int i = 0; i < n; i++) {
					line[i][0] = i - 1;
					line[i][1] = i + 1;
				}
				line[0][0] = -1;
				line[n - 1][1] = -1;
				for (int i = 0; i < b; i++) {
					int l = scanner.nextInt() - 1;
					int r = scanner.nextInt() - 1;
					if (line[l][0] >= 0) {
						int left = line[l][0];
						result.append(left + 1);
						line[left][1] = line[r][1];
					} else {
						result.append("*");
					}
					result.append(" ");
					if (line[r][1] >= 0) {
						int right = line[r][1];
						result.append(right + 1);
						line[right][0] = line[l][0];
					} else {
						result.append("*");
					}
					result.append("\n");
				}
				result.append("-\n");
			}
			System.out.println(result.toString().trim());
		}
	}

}
