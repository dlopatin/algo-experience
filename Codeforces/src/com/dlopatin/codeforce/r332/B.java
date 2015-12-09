package com.dlopatin.codeforce.r332;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/599/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int f[] = new int[n + 1];
			int freq[] = new int[n + 1];
			for (int i = 0; i < n; i++) {
				int nextF = scanner.nextInt();
				f[nextF] = i;
				freq[nextF]++;
			}
			int a[] = new int[m];
			boolean many = false;
			for (int i = 0; i < m; i++) {
				int b = scanner.nextInt();
				int idx = f[b];
				if (freq[b] == 0) {
					System.out.println("Impossible");
					return;
				} else if (freq[b] == 1) {
					a[i] = idx + 1;
				} else {
					many = true;
				}
			}
			if (many) {
				System.out.println("Ambiguity");
			} else {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < m; i++) {
					builder.append(a[i]).append(" ");
				}
				System.out.println("Possible");
				System.out.println(builder.toString().trim());
			}
		}
	}
}