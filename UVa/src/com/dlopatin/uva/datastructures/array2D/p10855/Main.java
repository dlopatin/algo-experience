package com.dlopatin.uva.datastructures.array2D.p10855;

import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=624&page=show_problem&problem=1796
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			StringBuilder result = new StringBuilder();
			int N = 0;
			while ((N = scanner.nextInt()) != 0) {
				int n = scanner.nextInt();
				char[][] big = new char[N][N];
				for (int i = 0; i < N; i++) {
					big[i] = scanner.next().toCharArray();
				}
				char[][] small = new char[n][n];
				for (int i = 0; i < n; i++) {
					small[i] = scanner.next().toCharArray();
				}
				for (int i = 0; i < 4; i++) {
					if (i > 0) {
						char[][] temp = new char[n][n];
						for (int a = 0, aa = 0; a < n && aa < n; a++, aa++) {
							for (int b = n - 1, bb = 0; b >= 0 && bb < n; b--, bb++) {
								temp[aa][bb] = small[b][a];
							}
						}
						small = temp;
					}
					int counter = 0;
					for (int bi = 0; bi <= N - n; bi++) {
						for (int bj = 0; bj <= N - n; bj++) {
							boolean doSmall = true;
							for (int si = 0; si < n; si++) {
								if (doSmall) {
									for (int sj = 0; sj < n; sj++) {
										if (big[bi + si][bj + sj] == small[si][sj]) {
											if (si == n - 1 && sj == n - 1) {
												counter++;
											}
										} else {
											doSmall = false;
											break;
										}
									}
								} else {
									break;
								}
							}
						}
					}
					result.append(counter).append(" ");
				}
				result.deleteCharAt(result.length() - 1);
				result.append("\n");
			}
			System.out.println(result.toString().trim());
		}
	}
}
