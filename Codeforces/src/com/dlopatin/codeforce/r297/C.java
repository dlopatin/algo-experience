package com.dlopatin.codeforce.r297;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://codeforces.com/contest/525/problem/C?locale=en
 */
public class C {

	public static void main(String[] args) {
		new C().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] lengths = new long[n];
			for (int i = 0; i < n; i++) {
				lengths[i] = scanner.nextLong();
			}
			Arrays.sort(lengths);
			long S = 0;
			long[] pairs = new long[2];
			int counter = 0;
			for (int i = n - 1; i >= 0; i--) {
				long current = lengths[i];
				if (i > 0) {
					long next = lengths[i - 1];
					if (current == next || current - 1 == next) {
						pairs[counter++] = next;
						i--;
					}
					if (counter == 2) {
						S += pairs[0] * pairs[1];
						counter = 0;
					}
				}
			}
			System.out.println(S);
		}
	}
}