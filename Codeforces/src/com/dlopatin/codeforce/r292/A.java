package com.dlopatin.codeforce.r292;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/516/problem/A
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int s = scanner.nextInt();
			int sum = Math.abs(a) + Math.abs(b);
			boolean can = false;
			if (sum <= s) {
				can = sum % 2 == s % 2;
			}

			System.out.println(can ? "Yes" : "No");
		}
	}

}
