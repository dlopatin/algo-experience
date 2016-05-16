package com.dlopatin.codeforce.r343;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/629/problem/A?locale=en
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] rowCnt = new int[n];
			int[] colCnt = new int[n];
			for (int i = 0; i < n; i++) {
				char[] chars = scanner.next().toCharArray();
				for (int j = 0; j < n; j++) {
					int chocolate = chars[j] == '.' ? 0 : 1;
					rowCnt[i] += chocolate;
					colCnt[j] += chocolate;
				}
			}
			long cnt = 0;
			for (int i = 0; i < n; i++) {
				cnt += calcCombination(rowCnt[i]);
				cnt += calcCombination(colCnt[i]);
			}
			System.out.println(cnt);
		}
	}

	private long calcCombination(int n) {
		return (n * (n - 1)) / 2;
	}

}