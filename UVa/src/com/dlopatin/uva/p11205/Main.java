package com.dlopatin.uva.p11205;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2146
*/
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().doJob();
	}

	private void doJob() throws NumberFormatException, IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- != 0) {
				int p = scanner.nextInt();
				int n = scanner.nextInt();
				int[] values = new int[n];
				for (int i = 0; i < n; i++) {
					int value = 0;
					for (int j = 0; j < p; j++) {
						value <<= 1;
						value |= scanner.nextInt();
					}
					values[i] = value;
				}
				int max = 0;
				for (int i = 0; i < (1 << p); i++) {
					Set<Integer> duplicateDetector = new HashSet<>();
					for (int j = 0; j < n; j++) {
						duplicateDetector.add(values[j] & i);
					}
					if (duplicateDetector.size() == n) {
						max = Math.max(max, calcLEDs(i, p));
					}
				}
				System.out.println(p - max);
			}

		}

	}

	private int calcLEDs(int mask, int p) {
		int res = 0;
		for (int i = 0; i < p; i++) {
			res += (mask & (1 << i)) == 0 ? 1 : 0;
		}
		return res;
	}
}
