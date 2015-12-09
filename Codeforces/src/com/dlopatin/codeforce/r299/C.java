package com.dlopatin.codeforce.r299;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/535/problem/C
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			while (n-- > 0) {
				int l = scanner.nextInt();
				int t = scanner.nextInt();
				int m = scanner.nextInt();
//			long[] s = new long[100000];
//			for (int i = 0; i < n; i++) {
//				s[i] = (a + i * b);
//			}
				long count = t * m;
				int r = l;
				for (int i = l - 1; count >= 0; i++) {
					count -= a + i * b;
					r = i;
				}
				System.out.println(r);
			}
		}
	}

}