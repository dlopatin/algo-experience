package com.dlopatin.codeforce.r358;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/682/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int a = Math.min(n, m);
			int b = Math.max(n, m);
			long count = 0;
			for (int i = 1; i <= a; i++) {
				if (5 - (i % 5) <= b) {
					count++;
				}
				if (b - 5 + (i % 5) > 0) {
					count += (b - 5 + (i % 5)) / 5;
				}
			}
			System.out.println(count);
		}
	}
}