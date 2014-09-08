package com.dlopatin.codechef.maylunchtime14;

import java.util.Scanner;

public class Approximately {

	public static void main(String[] args) {
		new Approximately().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfCases = scanner.nextInt();
			for (int caseIdx = 0; caseIdx < numberOfCases; caseIdx++) {
				int n = scanner.nextInt();
				long k = scanner.nextLong();
				long[] a = new long[n];
				for (int ni = 0; ni < n; ni++) {
					a[ni] = scanner.nextLong();
				}
				int count = 0;
				long minDiff = Long.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						long diff = Math.abs(a[i] + a[j] - k);
						if (diff < minDiff) {
							minDiff = diff;
							count = 1;
						} else if (minDiff == diff) {
							count++;
						}
					}
				}
				System.out.println(minDiff + " " + count);
			}
		}
	}

}