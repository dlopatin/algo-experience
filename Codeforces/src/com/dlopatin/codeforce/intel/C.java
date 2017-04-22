package com.dlopatin.codeforce.intel;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/722/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int[] sum = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
				if (i == 0) {
					sum[i] = a[i];
				} else {
					sum[i] = sum[i - 1] + a[i];
				}
			}
			for (int i = 0; i < n; i++) {
				int idx = scanner.nextInt();

			}
		}
	}

}