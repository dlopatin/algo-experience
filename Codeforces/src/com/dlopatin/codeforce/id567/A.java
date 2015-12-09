package com.dlopatin.codeforce.id567;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/567/problem/0
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] locations = new long[n];
			for (int i = 0; i < n; i++) {
				locations[i] = scanner.nextLong();
			}
			long[] min = new long[n - 1];
			long[] max = new long[n];
			for (int i = 0; i < n - 1; i++) {
				min[i] = Math.abs(-locations[i] + locations[i + 1]);
				max[i] = Math.max(Math.abs(locations[0] - locations[i]), Math.abs(locations[n - 1] - locations[i]));
			}
			max[n - 1] = max[0];
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < n; i++) {
				long min1 = i < n - 1 ? min[i] : min[i - 1];
				long min2 = i > 0 ? min[i - 1] : min[i];
				res.append(Math.min(min1, min2));
				res.append(" ");
				res.append(max[i]);
				res.append("\n");
			}
			System.out.println(res);
		}
	}
}