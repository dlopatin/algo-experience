package com.dlopatin.codeforce.r271;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/474/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] sum = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				sum[i] = sum[i - 1] + scanner.nextInt();
			}
			int m = scanner.nextInt();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < m; i++) {
				int q = scanner.nextInt();
				res.append(search(sum, q)).append(System.lineSeparator());
			}
			System.out.println(res);
		}
	}

	private int search(int array[], int key) {
		int min = 0;
		int max = array.length - 1;
		while (max >= min) {
			int mid = (min + max) / 2;
			if (array[mid] < key && array[mid + 1] >= key) {
				return mid + 1;
			} else if (array[mid] < key) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return 0;
	}

}
