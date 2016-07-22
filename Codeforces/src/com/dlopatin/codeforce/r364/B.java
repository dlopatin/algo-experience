package com.dlopatin.codeforce.r364;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/701/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			long free = n * (long) n;
			boolean[] tackenX = new boolean[n];
			boolean[] tackenY = new boolean[n];
			int usedRowsCnt = 0;
			int usedColsCnt = 0;
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < m; i++) {
				int x = scanner.nextInt() - 1;
				int y = scanner.nextInt() - 1;
				if (!tackenX[x]) {
					free -= n - usedRowsCnt;
					usedColsCnt++;
					tackenX[x] = true;
				}
				if (!tackenY[y]) {
					free -= n - usedColsCnt;
					usedRowsCnt++;
					tackenY[y] = true;
				}
				res.append(free).append(" ");
			}
			System.out.println(res.toString().trim());
		}

	}
}