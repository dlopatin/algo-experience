package com.dlopatin.codeforce.r353;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/675/problem/B?locale=en
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			int d1 = a + b + 2;
			int d2 = b + d + 2;
			int d3 = d + c + 2;
			int d4 = c + a + 2;

			int max = Math.max(d1, Math.max(d2, Math.max(d3, d4)));
			int min = Math.min(d1, Math.min(d2, Math.min(d3, d4)));
			int maxNumber = 1 + max - min;
			if (maxNumber > n) {
				System.out.println(0);
				return;
			}
			System.out.println((long) n * (n + 1 - maxNumber));

		}

	}
}