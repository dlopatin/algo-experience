package com.dlopatin.codeforce.r8vc;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/626/problem/C?locale=en
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int nL = n * 2;
			int mL = m * 3;
			int lenght = Math.max(nL, mL);
			nL = n / 3;
			mL = m / 2;
			int sameValueCnt = Math.min(n / 3, m / 2);
			while (sameValueCnt > 0) {

			}
		}
	}
}