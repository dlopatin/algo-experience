package com.dlopatin.codeforce.r316;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/570/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int numbersInRight = n - m;
			int numbersInLeft = m - 1;
			int res = 0;
			if (numbersInRight <= numbersInLeft) {
				res = numbersInLeft;
			} else {
				res = m + 1;
			}
			System.out.println(res == 0 ? 1 : res);
		}
	}
}