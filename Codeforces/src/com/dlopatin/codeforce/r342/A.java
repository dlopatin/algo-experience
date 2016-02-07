package com.dlopatin.codeforce.r342;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/625/problem/0
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			long c = scanner.nextLong();
			long cnt = 0;
			if (b - c >= a) {
				cnt = n / a;
			} else {
				if (n >= b) {
					cnt++; // as we bought first bottle
					cnt += (n - b) / (b - c);
					n -= cnt * (b - c);
				}
				cnt += n / a;
			}
			System.out.println(cnt);
		}
	}
}