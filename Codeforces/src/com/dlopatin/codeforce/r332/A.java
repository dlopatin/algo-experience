package com.dlopatin.codeforce.r332;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/599/problem/0
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextInt();
			long b = scanner.nextInt();
			long c = scanner.nextInt();
			System.out.println((Math.min(a + b + c, Math.min(2 * a + 2 * b, Math.min(2 * (a + c), 2 * (b + c))))));
		}
	}
}