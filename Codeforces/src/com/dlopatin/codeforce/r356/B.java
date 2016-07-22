package com.dlopatin.codeforce.r356;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/680/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a = scanner.nextInt() - 1;
			int[] data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = scanner.nextInt();
			}
			int sum = data[a];
			int steps = Math.min(a, n - 1 - a);
			for (int i = 1; i <= steps; i++) {
				int num = 0;
				num += data[a - i];
				num += data[a + i];
				num = num == 1 ? 0 : num;
				sum += num;
			}
			if (steps == a) {
				// right
				for (int i = a + steps + 1; i < data.length; i++) {
					sum += data[i];
				}
			} else {
				for (int i = a - steps - 1; i >= 0; i--) {
					sum += data[i];
				}
			}
			System.out.println(sum);
		}

	}
}