package com.dlopatin.codeforce.r367;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/706/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Integer[] x = new Integer[n];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				x[i] = scanner.nextInt();
				max = Math.max(x[i], max);
			}
			Arrays.sort(x);
			int q = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < q; i++) {
				int m = scanner.nextInt();
				if (m >= max) {
					res.append(n);
				} else {
					res.append(binarySearch(x, m));
				}
				res.append("\n");
			}
			System.out.println(res.toString().trim());
		}
	}

	private int binarySearch(Integer[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int res = -1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal <= key) {
				low = mid + 1;
				res = mid;
			} else {
				high = mid - 1;
			}
		}
		return res + 1;
	}

}