package com.dlopatin.contest.projecteuler;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler003
*/
public class P3_LargestPrimeFactor {

	public static void main(String[] args) {
		new P3_LargestPrimeFactor().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			while (t-- > 0) {
				long n = scanner.nextLong();
				long d = 2;
				while (n > 1) {
					while (n % d == 0) {
						n /= d;
					}
					d++;
					if (d * d > n) {
						if (n > 1) {
							d = n + 1;
						}
						break;
					}
				}
				res.append(d - 1);
				res.append(System.lineSeparator());
			}
			System.out.println(res.toString().trim());
		}
	}

}
