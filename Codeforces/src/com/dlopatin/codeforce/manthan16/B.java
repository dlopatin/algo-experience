package com.dlopatin.codeforce.manthan16;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/633/problem/B
 */
public class B {

	public static void main(String[] args) {
		new B().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt();
			int count = 0;
			StringBuilder builder = new StringBuilder();
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				int trailingZeros = countTrailingZeros(i);
				if (trailingZeros > m) {
					break;
				}
				if (trailingZeros == m) {
					count++;
					builder.append(i).append(" ");
				}
			}
			System.out.println(count);
			if (count > 0) {
				System.out.println(builder.toString().trim());
			}
		}
	}

	private int countTrailingZeros(int number) {
		int result = 0;
		for (int i = 1; number / Math.pow(5, i) >= 1; i++) {
			result += number / Math.pow(5, i);
		}
		return result;
	}
}