package com.dlopatin.codeforce.r267;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/467/problem/B
 */
public class B {

	public static void main(String[] args) throws IOException, ParseException {
		new B().doJob();
	}

	private void doJob() throws ParseException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			int[] x = new int[m];
			for (int i = 0; i < m; i++) {
				x[i] = scanner.nextInt();
			}
			int standard = scanner.nextInt();
			int count = 0;
			for (int i = 0; i < m; i++) {
				int diff = 0;
				for (int j = 0; j < n; j++) {
					if (getBit(standard, j) != getBit(x[i], j)) {
						diff++;
					}
					if (diff > k) {
						break;
					}
				}
				if (diff <= k) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private int getBit(int number, int pos) {
		return (number >> pos) & 1;
	}

}
