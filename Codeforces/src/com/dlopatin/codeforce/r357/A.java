package com.dlopatin.codeforce.r357;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/681/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			while (n-- > 0) {
				scanner.next();
				int before = scanner.nextInt();
				int after = scanner.nextInt();
				if (before >= 2400 && after - before > 0) {
					System.out.println("YES");
					return;
				}
			}
			System.out.println("NO");
		}
	}
}