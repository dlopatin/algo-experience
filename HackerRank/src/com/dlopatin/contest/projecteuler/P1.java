package com.dlopatin.contest.projecteuler;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		new P1().doJob();
	}

	private void doJob() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			StringBuilder res = new StringBuilder();
			while (t-- > 0) {
				long last = sc.nextInt() - 1;
				long sum = arithmeticSum(last, 3);
				sum -= arithmeticSum(last, 15);
				sum += arithmeticSum(last, 5);
				res.append(sum).append(System.lineSeparator());
			}
			System.out.println(res.toString().trim());
		}
	}

	private long arithmeticSum(long last, int d) {
		int a1 = d;
		long n = last / d;
		return ((2 * a1 + d * (n - 1)) * n) / 2;
	}

}
