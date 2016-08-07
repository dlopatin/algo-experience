package com.dlopatin.codeforce.r366;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/705/problem/A
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String hate = "I hate ";
			String love = "I love ";
			String last = "it";
			String delimeter = "that ";
			String res = "";
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					res += hate;
				} else {
					res += love;
				}
				if (i < n - 1) {
					res += delimeter;
				}
			}
			res += last;
			System.out.println(res);

		}
	}
}