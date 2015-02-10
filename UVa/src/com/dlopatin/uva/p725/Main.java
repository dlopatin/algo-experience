package com.dlopatin.uva.p725;

import java.util.Scanner;

/*
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=361&page=show_problem&problem=666
*/
public class Main {

	public static void main(String[] args) {
		new Main().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = 0;
			StringBuilder result = new StringBuilder();
			while ((n = scanner.nextInt()) != 0) {
				final int start = 1234;
				final int end = 98765;
				boolean foundResult = false;
				for (int i = start; i * n < end; i++) {
					int b = i * n;
					if (isUnique(i, b)) {
						foundResult = true;
						result.append(String.format("%05d", b)).append(" / ").append(String.format("%05d", i))
								.append(" = ").append(n).append(System.lineSeparator());
					}
				}
				if (!foundResult) {
					result.append("There are no solutions for " + n + ".\n");
				}
				result.append(System.lineSeparator());
			}
			System.out.println(result.toString().trim());
		}

	}

	private boolean isUnique(int a, int b) {
		int[] digits = new int[10];
		findAndFillDigits(digits, a);
		findAndFillDigits(digits, b);
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] > 1) {
				return false;
			}
		}
		return true;
	}

	private void findAndFillDigits(int[] digits, int number) {
		for (int i = 0; i < 5; i++) {
			int digit = number % 10;
			number /= 10;
			digits[digit]++;
		}
	}

}
