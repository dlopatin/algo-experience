package com.dlopatin.codeforce.aimtech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/624/problem/B
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long array[] = new long[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextLong();
			}
			List<Long> used = new ArrayList<>();
			long res = 0;
			for (long a : array) {
				while (used.contains(a) && a > 0) {
					a--;
				}
				used.add(a);
				res += a;
			}
			System.out.println(res);
		}
	}
}