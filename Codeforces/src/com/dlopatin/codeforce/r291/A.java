package com.dlopatin.codeforce.r291;

import java.util.Scanner;

/**
 * http://codeforces.com/contest/514/problem/A
 *
 */
public class A {

	public static void main(String[] args) {
		new A().doJob();
	}

	private void doJob() {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] number = scanner.next().toCharArray();
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < number.length; i++) {
				int digit = Character.getNumericValue(number[i]);
				if (digit > 4) {
					digit = 9 - digit;
				}
				if (i == 0 && digit == 0) {
					digit = 9;
				}
				res.append(digit);
			}

			long result = Long.parseLong(res.toString());
			System.out.println(result);
		}
	}

}
