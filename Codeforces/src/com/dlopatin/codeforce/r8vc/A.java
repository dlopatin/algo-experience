package com.dlopatin.codeforce.r8vc;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/626/problem/A?locale=en
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			char[] s = scanner.next().toCharArray();
			int number = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int[] cnt = new int[200];
					for (int k = i; k <= j; k++) {
						cnt[s[k]]++;
					}
					if (cnt['U'] == cnt['D'] && cnt['L'] == cnt['R']) {
						number++;
					}
				}
			}
			System.out.println(number);
		}
	}
}