package com.dlopatin.codeforce.r362;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/697/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			int s = scanner.nextInt();
			int x = scanner.nextInt();
			if (x < t) {
				System.out.println("NO");
				return;
			}
			if (x == t) {
				System.out.println("YES");
				return;
			}
			int idx = (x - t) / s;
			if (idx > 0) {
				int val = idx * s + t;
				while (val <= x) {
					if (val == x || val + 1 == x) {
						System.out.println("YES");
						return;
					}
					val = ++idx * s + t;
				}
			}
			System.out.println("NO");
		}
	}
}