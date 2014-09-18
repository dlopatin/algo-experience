package com.dlopatin.codeforce.r267;

import java.util.Scanner;

/**
 * http://codeforces.com/problemset/problem/467/A
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int count = 0;
			for (int i = 0; i < n; i++) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if (q - p >= 2) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
