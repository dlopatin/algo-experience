package com.dlopatin.problems;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/707/problem/A
 */
public class PairSum {

	public static void main(String[] args) {
		new PairSum().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			System.out.println(ok(a, b, c, d));
		}
	}

	private boolean ok(int a, int b, int c, int d) {
		if (a == c && b == d) {
			return true;
		} else if (a <= c && b <= d) {
			return ok(a + b, b, c, d) || ok(a, a + b, c, d);
		}
		return false;
	}
}