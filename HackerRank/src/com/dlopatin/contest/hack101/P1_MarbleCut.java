package com.dlopatin.contest.hack101;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/contests/101hack22/challenges/marble-cut
*/
public class P1_MarbleCut {

	public static void main(String[] args) {
		new P1_MarbleCut().doJob();
	}

	private void doJob() {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			StringBuilder res = new StringBuilder();
			while (t-- > 0) {
				long a = sc.nextInt();
				long b = sc.nextInt();
				if (a % 3 == 0 || b % 3 == 0) {
					res.append("YES");
				} else if (a < 3 || b < 3) {
					res.append("NO ").append((a % 3) * (b % 3));
				} else {
					res.append("NO ").append((a * b) % 3);
				}
				res.append(System.lineSeparator());
			}
			System.out.println(res.toString().trim());
		}
	}
}
