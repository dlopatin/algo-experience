package com.dlopatin.codeforce.aimtech;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/624/problem/0
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int d = scanner.nextInt();
			int L = scanner.nextInt();
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			double res = ((double) (L - d)) / (v1 + v2);
			System.out.printf("%.6f\n", res);
		}
	}
}