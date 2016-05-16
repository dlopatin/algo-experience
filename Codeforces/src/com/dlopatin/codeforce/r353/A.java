package com.dlopatin.codeforce.r353;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/675/problem/A?locale=en
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a1 = scanner.nextInt();
			int an = scanner.nextInt();
			int d = scanner.nextInt();
			boolean res = false;
			if (d == 0) {
				res = an == a1;
			} else {
				res = ((an - a1) / d >= 0 && (an - a1) % d == 0);
			}
			System.out.println(res ? "YES" : "NO");
		}
	}
}